package tensors.test;

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

        firstTensor = new Tensor('A', (byte)4);
        secondTensor = new Tensor('M', (byte)2);
        thirdTensor = new Tensor('F', (byte)4);

        char[][] leftCoefficients = new char[][]{{'n'},{'m'}};
        char[][] rightCoefficients = new char[][]{{'x'}};

        firstTensor.setLeftCoefficients(leftCoefficients);
        firstTensor.setRightCoefficients(rightCoefficients);
        secondTensor.setLeftCoefficients(leftCoefficients);
        secondTensor.setRightCoefficients(rightCoefficients);

    }


    @Test
    public void addTensors() {

        char[][] leftCoefficients = new char[][]{{'n'},{'m'}};
        char[][] rightCoefficients = new char[][]{{'x'}};

        firstTensor.setLeftCoefficients(leftCoefficients);
        firstTensor.setRightCoefficients(rightCoefficients);
        secondTensor.setLeftCoefficients(leftCoefficients);
        secondTensor.setRightCoefficients(rightCoefficients);



        assertEquals(null, tensorWorker.addTensors(firstTensor,secondTensor));
    }


    @Test
    public void subtractTensors() {

        char[][] leftCoefficients = new char[][]{{'n'},{'m'}};
        char[][] rightCoefficients = new char[][]{{'x'}};

        firstTensor.setLeftCoefficients(leftCoefficients);
        firstTensor.setRightCoefficients(rightCoefficients);
        secondTensor.setLeftCoefficients(leftCoefficients);
        secondTensor.setRightCoefficients(rightCoefficients);

        assertEquals(null, tensorWorker.subtractTensors(firstTensor,secondTensor));
    }


    @Test
    public void multiplyTensors() {

        char[][] leftCoefficients = new char[][]{{'n'},{'m'}};
        char[][] rightCoefficients = new char[][]{{'x'}};

        firstTensor.setLeftCoefficients(leftCoefficients);
        firstTensor.setRightCoefficients(rightCoefficients);
        secondTensor.setLeftCoefficients(leftCoefficients);
        secondTensor.setRightCoefficients(rightCoefficients);
        assertEquals(null, tensorWorker.multiplyTensors(firstTensor,secondTensor));
    }
}