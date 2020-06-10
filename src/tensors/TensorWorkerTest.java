package tensors;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TensorWorkerTest {

    Tensor firstTensor;
    Tensor secondTensor;
    Tensor thirdTensor;
    Tensor fourthTensor;
    Tensor fifthTensor;



    TensorWorker tensorWorker = new TensorWorker();


    @Before
    public void initTensors(){

        firstTensor = new Tensor('C');
        secondTensor = new Tensor('D');
        thirdTensor = new Tensor('E');

        fourthTensor = new Tensor('A');
        fifthTensor = new Tensor('A');

        char[] TopCoefficientsBasic = {'x','a','m','n','o'};
        char[] BottomCoefficientsBasic = {'m','o','f','l','k'};

        char[] TopCoefficientsResult = {'x','a','n'};
        char[] BottomCoefficientsResult = {'f','l','k'};

        char[] ShortTopCoefficients = {'x','m'};
        char[] ShortBottomCoefficients = {'m'};

        //1
        firstTensor.setRightTopCoefficients(ShortTopCoefficients);
        firstTensor.setRightBottomCoefficients(ShortBottomCoefficients);
        firstTensor.setLeftTopCoefficients(ShortTopCoefficients);
        firstTensor.setLeftBottomCoefficients(ShortBottomCoefficients);

        //2
        secondTensor.setRightTopCoefficients(ShortTopCoefficients);
        secondTensor.setRightBottomCoefficients(ShortBottomCoefficients);
        secondTensor.setLeftTopCoefficients(ShortTopCoefficients);
        secondTensor.setLeftBottomCoefficients(ShortBottomCoefficients);


        //3
        thirdTensor.setRightTopCoefficients(ShortTopCoefficients);
        thirdTensor.setRightBottomCoefficients(ShortBottomCoefficients);
        thirdTensor.setLeftTopCoefficients(ShortTopCoefficients);
        thirdTensor.setLeftBottomCoefficients(ShortBottomCoefficients);


        //4
        fourthTensor.setRightTopCoefficients(TopCoefficientsBasic);
        fourthTensor.setRightBottomCoefficients(BottomCoefficientsBasic);
        fourthTensor.setLeftTopCoefficients(TopCoefficientsBasic);
        fourthTensor.setLeftBottomCoefficients(BottomCoefficientsBasic);


        //5
        fifthTensor.setRightTopCoefficients(TopCoefficientsResult);
        fifthTensor.setRightBottomCoefficients(BottomCoefficientsResult);
        fifthTensor.setLeftTopCoefficients(TopCoefficientsResult);
        fifthTensor.setLeftBottomCoefficients(BottomCoefficientsResult);


    }


    @Test
    public void addTensors() {

        Tensor resultTensor = tensorWorker.addTensors(firstTensor, secondTensor);
        if(resultTensor != null){
            assertEquals(thirdTensor.name, resultTensor.name);
            assertEquals(thirdTensor.rank, resultTensor.rank);
            assertArrayEquals(thirdTensor.existingIndexes, resultTensor.existingIndexes);
        }
    }


    @Test
    public void subtractTensors() {

        Tensor resultTensor = tensorWorker.subtractTensors(firstTensor, secondTensor);
        if(resultTensor != null) {
            assertEquals(thirdTensor.name, resultTensor.name);
            assertEquals(thirdTensor.rank, resultTensor.rank);
            assertArrayEquals(thirdTensor.existingIndexes, resultTensor.existingIndexes);
        }
    }


    @Test
    public void convolutionTensors() {

        Tensor resultTensor = tensorWorker.convolutionTensors(fourthTensor);

        assertEquals(fifthTensor.name, resultTensor.name);
        assertEquals(fifthTensor.rank, resultTensor.rank);
        assertArrayEquals(fifthTensor.existingIndexes, resultTensor.existingIndexes);

        /*

        if(resultTensor.existingIndexes[3]) {

            for (int i = 0; i < resultTensor.rightTopCoefficients.length; i++) {
                if(fifthTensor.rightTopCoefficients[i] != resultTensor.rightTopCoefficients[i]) {
                    ifValuesEqual = false;
                }
            }
        }


        if(resultTensor.existingIndexes[2]) {

            for (int i = 0; i < resultTensor.rightBottomCoefficients.length; i++) {
                if(fifthTensor.rightBottomCoefficients[i] != resultTensor.rightBottomCoefficients[i]) {
                    ifValuesEqual = false;
                }
            }
        }


        if(resultTensor.existingIndexes[1]) {

            for (int i = 0; i < resultTensor.leftTopCoefficients.length; i++) {
                if (fifthTensor.leftTopCoefficients[i] != resultTensor.leftTopCoefficients[i]) {
                    ifValuesEqual = false;
                }
            }
        }


        if(resultTensor.existingIndexes[0]) {
            for (int i = 0; i < resultTensor.leftBottomCoefficients.length; i++) {
                if(fifthTensor.leftBottomCoefficients[i] != resultTensor.leftBottomCoefficients[i]) {
                    ifValuesEqual = false;
                }
            }
        }

        assertEquals(true, ifValuesEqual);

        */

    }


    @Test
    public void multiplyTensors() {

        //3
        thirdTensor.setRightTopCoefficients(new char[]{'m'});
        thirdTensor.setRightBottomCoefficients(new char[]{'m'});
        thirdTensor.setLeftTopCoefficients(new char[]{'x'});
        thirdTensor.setLeftBottomCoefficients(new char[]{'x'});

        //4
        fourthTensor.setRightTopCoefficients(new char[]{'x'});
        fourthTensor.setRightBottomCoefficients(new char[]{'x'});
        fourthTensor.setLeftTopCoefficients(new char[]{'x'});
        fourthTensor.setLeftBottomCoefficients(new char[]{'x'});


        //5
        fifthTensor.setRightTopCoefficients(new char[]{'x','m'});
        fifthTensor.setRightBottomCoefficients(new char[]{'m'});
        fifthTensor.setLeftTopCoefficients(new char[]{'m'});
        fifthTensor.setLeftBottomCoefficients(new char[]{'m'});

        Tensor resultTensor = tensorWorker.multiplyTensors(firstTensor,secondTensor);

    }

}
