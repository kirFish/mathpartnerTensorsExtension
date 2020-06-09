package tensors;

import java.util.Arrays;

public class TensorWorker implements TensorFunctions {


    //to add two tensors they must have the same indexes
    // if return null then the operation is not possible for input tensors
    @Override
    public Tensor addTensors(Tensor firstTensor, Tensor secondTensor) {

        if (checkIfConditionsAreMet(firstTensor, secondTensor)) {

            firstTensor.name = getNewTensorName(firstTensor.name, secondTensor.name);
            return firstTensor;
        } else {
            return null;
        }
    }


    //to subtract two tensors they must have the same indexes
    @Override
    public Tensor subtractTensors(Tensor firstTensor, Tensor secondTensor) {

        if (checkIfConditionsAreMet(firstTensor, secondTensor)) {

            firstTensor.name = getNewTensorName(firstTensor.name, secondTensor.name);
            return firstTensor;
        } else {
            return null;
        }
    }


    @Override
    public Tensor multiplyTensors(Tensor firstTensor, Tensor secondTensor) {
//
//        Tensor resultTensor = new Tensor('A', (byte) 0);
//
//
//        resultTensor.rightBottomCoefficients =
//                addCorrespondingCoefficients(true, firstTensor.rightBottomCoefficients, secondTensor.rightBottomCoefficients);
//
//        resultTensor.rightTopCoefficients =
//                addCorrespondingCoefficients(true, firstTensor.rightBottomCoefficients, secondTensor.rightBottomCoefficients);
//
//        resultTensor.rank = (byte) (firstTensor.rank + secondTensor.rank);
//

        return null;
    }

    @Override
    public Tensor convolutionTensors(Tensor tensor) {
        return null;
    }


//    //if coefficient are the same they self-destruct in the "coefficientsConvolution method"
//    private char[] addCorrespondingCoefficients(boolean ifRightCoefficient, char[] firstCoefficients, char[] secondCoefficients) {
//
//        char[][] resultCoefficients = new char[2][firstCoefficients.length + secondCoefficients.length];
//
//
//        //this index says if we write to right or left indexes at the result
//        int firstResultIndex = 0;
//        if (ifRightCoefficient) {
//            firstResultIndex = 1;
//
//        }
//
//        writeBottomCoefficients(resultCoefficients, firstResultIndex, firstCoefficients, secondCoefficients);
//
//        writeTopCoefficients(resultCoefficients, firstResultIndex, firstCoefficients, secondCoefficients);
//
//
//        return resultCoefficients;
//    }


    private char[][] addTwoCharArray(char[][] resultCoefficients, int firstResultIndex, char[][] firstCoefficients, char[][] secondCoefficients) {

        //writing the top coefficients
        for (int resultCounter = 0; resultCounter < resultCoefficients.length; resultCounter++) {

            if (resultCounter < firstCoefficients.length) {

                resultCoefficients[firstResultIndex++][resultCounter] = firstCoefficients[1][resultCounter];
            } else {
                resultCoefficients[firstResultIndex++][resultCounter] = secondCoefficients[1][resultCounter];

            }
        }

        return resultCoefficients;
    }


    private char getNewTensorName(char firstName, char secondName) {

        firstName = (char) (firstName + 1);

        if (firstName != secondName) {
            return firstName;
        } else {
            char secondNameOption = (char) (secondName + 1);
            return secondNameOption;
        }
    }


    private boolean checkIfConditionsAreMet(Tensor firstTensor, Tensor secondTensor) {

        boolean[] conditionsArray = new boolean[4];

        //existing indexes
        // left bottom = 0
        // left top = 1
        // right bottom = 2
        // right top = 3

        if ((firstTensor.existingIndexes[0]) && (secondTensor.existingIndexes[0])) {

            if (Arrays.equals(firstTensor.leftBottomCoefficients, secondTensor.leftBottomCoefficients)) {

                conditionsArray[0] = true;

            } else {

                conditionsArray[0] = false;
            }

        }else{
            conditionsArray[0] = !firstTensor.existingIndexes[0] && !secondTensor.existingIndexes[0];
        }

        if ((firstTensor.existingIndexes[1]) && (secondTensor.existingIndexes[1])) {

            if (Arrays.equals(firstTensor.leftTopCoefficients, secondTensor.leftTopCoefficients)) {

                conditionsArray[1] = true;

            } else {

                conditionsArray[1] = false;
            }

        }else{
            conditionsArray[1] = !firstTensor.existingIndexes[1] && !secondTensor.existingIndexes[1];
        }

        if ((firstTensor.existingIndexes[2]) && (secondTensor.existingIndexes[2])) {

            if (Arrays.equals(firstTensor.rightBottomCoefficients, secondTensor.rightBottomCoefficients)) {

                conditionsArray[2] = true;

            } else {

                conditionsArray[2] = false;
            }

        }else{
            conditionsArray[2] = !firstTensor.existingIndexes[2] && !secondTensor.existingIndexes[2];
        }

        if ((firstTensor.existingIndexes[3]) && (secondTensor.existingIndexes[3])) {

            if (Arrays.equals(firstTensor.rightTopCoefficients, secondTensor.rightTopCoefficients)) {

                conditionsArray[3] = true;

            } else {

                conditionsArray[3] = false;
            }

        }else{
            conditionsArray[3] = !firstTensor.existingIndexes[3] && !secondTensor.existingIndexes[3];
        }



        boolean conditionIsMet = conditionsArray[0] && conditionsArray[1] && conditionsArray[2] && conditionsArray[3];

        return conditionIsMet;
    }

//    //deletes the sam-+e coefficients for the top and bottom on each side
//    //works only for the right coefficients!!
//    private char[][] coefficientsConvolution(char[][] resultCoefficients) {
//
//
//        int[] sameCoeff;
//        char[] rightTop = resultCoefficients[]
//        char[] rightBottom = resultCoefficients[]
//
//        //find the indexes of the same if they exist
//        for (int i = 0; i < resultCoefficients; i++) {
//
//        }
//
//
//        return resultCoefficients;
//    }

}
