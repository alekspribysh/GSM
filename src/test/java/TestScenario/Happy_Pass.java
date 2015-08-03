package TestScenario;
import Signature.*;
import org.junit.Test;

/**
 * Created by aleksandr on 11/10/14.
 */
public class Happy_Pass
{
    TestCases test = new TestCases();


    @Test
    public void testSuite() throws Exception {
        test.advertiserGet();
        test.adUnittGet();
        test.asset_groupGet();
        test.assettGet();
    }

}
