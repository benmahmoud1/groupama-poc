package com.poc.springbatch;

import com.poc.springbatch.misc.UtilsTools;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class SpringBatchApplicationTests {

    @Test
    void contextLoads() {
        var val = 0.0;
        val = UtilsTools.rivageStringToDecimal("000000000000000{");
        assertThat(val).isEqualTo(0.00);
        val = UtilsTools.rivageStringToDecimal("000000000003000{");
        assertThat(val).isEqualTo(300.00);
        val = UtilsTools.rivageStringToDecimal("0000000030{");
        assertThat(val).isEqualTo(3.00);
        val = UtilsTools.rivageStringToDecimal("000000000080050}");
        assertThat(val).isEqualTo(-8005.00);
        val = UtilsTools.rivageStringToDecimal("000000000080050}");
        assertThat(val).isEqualTo(-8005.00);

        val = UtilsTools.rivageStringToDecimal("000000000007609B");
        assertThat(val).isEqualTo(760.92);
        val = UtilsTools.rivageStringToDecimal("000000000000820H");
        assertThat(val).isEqualTo(82.08);
        val = UtilsTools.rivageStringToDecimal("000000000002557J");
        assertThat(val).isEqualTo(-255.71);
        val = UtilsTools.rivageStringToDecimal("000000000002465M");
        assertThat(val).isEqualTo(-246.54);
        val = UtilsTools.rivageStringToDecimal("000000000002037R");
        assertThat(val).isEqualTo(-203.79);
    }
}
