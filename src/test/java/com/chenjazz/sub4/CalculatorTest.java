package com.chenjazz.sub4;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjazz
 * @since 2018/7/14
 */
public class CalculatorTest {
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    @Test
    public void testCalculate() throws ScriptException {
        List<String> exprList = new ArrayList<>();
        exprList.add("3*0+3+8+9*1");
        exprList.add("3+(3-0)*2");

        for (String expr : exprList) {
            Assert.assertEquals(expr + " 计算错误", Calculator.calculate(expr), engine.eval(expr));
        }
    }
}
