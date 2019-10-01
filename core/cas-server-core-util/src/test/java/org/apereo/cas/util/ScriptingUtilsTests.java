package org.apereo.cas.util;

import org.apereo.cas.util.scripting.ScriptingUtils;

import lombok.val;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link ScriptingUtilsTests}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
public class ScriptingUtilsTests {

    @Test
    void verifyInlineGroovyScript() {
        assertTrue(ScriptingUtils.isInlineGroovyScript("groovy {return 0}"));
    }

    @Test
    void verifyExternalGroovyScript() {
        assertTrue(ScriptingUtils.isExternalGroovyScript("file:/tmp/sample.groovy"));
    }

    @Test
    void verifyGroovyScriptShellExecution() {
        val script = ScriptingUtils.parseGroovyShellScript("return name");
        val result = ScriptingUtils.executeGroovyShellScript(script, CollectionUtils.wrap("name", "casuser"), String.class);
        assertEquals("casuser", result);
    }

    @Test
    void verifyGroovyResourceFileExecution() throws IOException {
        val file = File.createTempFile("test", ".groovy");
        FileUtils.write(file, "def process(String name) { return name }", StandardCharsets.UTF_8);
        val resource = new FileSystemResource(file);

        val result = ScriptingUtils.executeGroovyScript(resource, "process", String.class, "casuser");
        assertEquals("casuser", result);
    }

    @Test
    void verifyGroovyResourceFileNotFound() {
        val resource = new FileSystemResource(new File("missing.groovy"));

        val result = ScriptingUtils.executeGroovyScript(resource, "process", String.class, "casuser");
        assertNull(result);
    }

    @Test
    void verifyGroovyResourceClasspathExecution() {
        val resource = new ClassPathResource("ScriptingUtilsTestGroovyScript.groovy");

        val result = ScriptingUtils.executeGroovyScript(resource, "process", String.class, "casuser");
        assertEquals("casuser", result);
    }

    @Test
    void verifyGroovyResourceClasspathNotFound() {
        val resource = new ClassPathResource("missing.groovy");

        val result = ScriptingUtils.executeGroovyScript(resource, "process", String.class, "casuser");
        assertNull(result);
    }

    @Test
    void verifyGroovyResourceEngineExecution() {
        val result = ScriptingUtils.executeGroovyScriptEngine("return name", CollectionUtils.wrap("name", "casuser"), String.class);
        assertEquals("casuser", result);
    }

    @Test
    void verifyResourceScriptEngineExecution() throws IOException {
        val file = File.createTempFile("test", ".groovy");
        FileUtils.write(file, "def run(String name) { return name }", StandardCharsets.UTF_8);

        val result = ScriptingUtils.executeScriptEngine(file.getCanonicalPath(), new Object[]{"casuser"}, String.class);
        assertEquals("casuser", result);
    }
}
