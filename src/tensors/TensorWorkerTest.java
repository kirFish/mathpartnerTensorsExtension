package tensors;

import org.junit.Before;
import org.junit.Test;
import tensors.Tensor;
import tensors.TensorFunctions;
import tensors.TensorWorker;

import static org.junit.Assert.assertEquals;

public class TensorWorkerTest {

    Tensor firstTensor;
    Tensor secondTensor;
    Tensor thirdTensor;

    TensorWorker tensorWorker = new TensorWorker();

    @Before
    public void initTensors(){

        firstTensor = new Tensor('A', (byte)2);
        secondTensor = new Tensor('M', (byte)2);
        thirdTensor = new Tensor('B', (byte)2);

        char[] rightTopCoefficients = {'x'};
        char[] rightBottomCoefficients = {'m'};

        firstTensor.setRightTopCoefficients(rightTopCoefficients);
        firstTensor.setRightBottomCoefficients(rightBottomCoefficients);

        secondTensor.setRightTopCoefficients(rightTopCoefficients);
        secondTensor.setRightBottomCoefficients(rightBottomCoefficients);

    }


    @Test
    public void addTensors() {


        assertEquals(thirdTensor, tensorWorker.addTensors(firstTensor,secondTensor));
    }


    @Test
    public void subtractTensors() {

        assertEquals(thirdTensor, tensorWorker.subtractTensors(firstTensor,secondTensor));
    }

}