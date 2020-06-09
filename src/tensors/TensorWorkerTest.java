package tensors;

import org.junit.Before;
import org.junit.Test;
import tensors.Tensor;
import tensors.TensorFunctions;
import tensors.TensorWorker;

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

        firstTensor = new Tensor('C', (byte)2);
        secondTensor = new Tensor('D', (byte)2);
        thirdTensor = new Tensor('E', (byte)2);

        fourthTensor = new Tensor('A', (byte) 20);
        fifthTensor = new Tensor('A', (byte) 12);

        char[] TopCoefficientsBasic = {'x','a','m','n','o'};
        char[] BottomCoefficientsBasic = {'m','o','f','l','k'};

        char[] TopCoefficientsResult = {'x','a','n'};
        char[] BottomCoefficientsResult = {'f','l','k'};

        char[] rightTopCoefficients = {'x'};
        char[] rightBottomCoefficients = {'m'};

        firstTensor.setRightTopCoefficients(rightTopCoefficients);
        firstTensor.setRightBottomCoefficients(rightBottomCoefficients);

        secondTensor.setRightTopCoefficients(rightTopCoefficients);
        secondTensor.setRightBottomCoefficients(rightBottomCoefficients);

        thirdTensor.setRightTopCoefficients(rightTopCoefficients);
        thirdTensor.setRightBottomCoefficients(rightBottomCoefficients);

        fourthTensor.setRightTopCoefficients(TopCoefficientsBasic);
        fourthTensor.setRightBottomCoefficients(BottomCoefficientsBasic);
        fourthTensor.setLeftTopCoefficients(TopCoefficientsBasic);
        fourthTensor.setLeftBottomCoefficients(BottomCoefficientsBasic);

        fifthTensor.setRightTopCoefficients(TopCoefficientsResult);
        fifthTensor.setRightBottomCoefficients(BottomCoefficientsResult);
        fifthTensor.setLeftTopCoefficients(TopCoefficientsResult);
        fifthTensor.setLeftBottomCoefficients(BottomCoefficientsResult);


    }


    @Test
    public void addTensors() {

        Tensor resultTensor = tensorWorker.addTensors(firstTensor, secondTensor);
        assertEquals(thirdTensor.name, resultTensor.name);
        assertEquals(thirdTensor.rank, resultTensor.rank);
        System.out.println(Arrays.equals(thirdTensor.existingIndexes, tensorWorker.addTensors(firstTensor,secondTensor).existingIndexes));
    }


    @Test
    public void subtractTensors() {

        Tensor resultTensor = tensorWorker.subtractTensors(firstTensor, secondTensor);
        assertEquals(thirdTensor.name, resultTensor.name);
        assertEquals(thirdTensor.rank, resultTensor.rank);
        System.out.println(Arrays.equals(thirdTensor.existingIndexes, resultTensor.existingIndexes));
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

}