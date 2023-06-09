package imqa.dashboard.dao;

import imqa.dashboard.vo.MetricVo;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetricDaoTest {

    @Test
    public void metricDao() throws IOException {

        List<MetricVo> result = new MetricDao(new File("/Users/id_sucheol/Downloads/MatricListF.xlsx")).readExcel();

        System.out.println(result);

        Assert.assertNotEquals(result.size(), 0);
    }
}