package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.*;

public class TestEnums extends XmlTestBase
{
    static enum TestEnum { A, B, C; }

    static class EnumBean
    {
        public TestEnum value;

        public EnumBean() { }
        public EnumBean(TestEnum v) { value = v; }
    }

    /*
    /**********************************************************
    /* Unit tests
    /**********************************************************
     */

    private final XmlMapper MAPPER = new XmlMapper();
    
    public void testEnum() throws Exception
    {
        String xml = MAPPER.writeValueAsString(new EnumBean(TestEnum.B));
        EnumBean result = MAPPER.readValue(xml, EnumBean.class);
        assertNotNull(result);
        assertEquals(TestEnum.B, result.value);
    }
}
