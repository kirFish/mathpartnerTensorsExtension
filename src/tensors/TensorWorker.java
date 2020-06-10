package tensors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TensorWorker implements TensorFunctions {

    @Override
    public Tensor addTensors(Tensor firstTensor, Tensor secondTensor) {

        if (checkIfConditionsAreMet(firstTensor, secondTensor)) {

            firstTensor.name = getNewTensorName(firstTensor.name, secondTensor.name);
            return firstTensor;
        } else {
            return null;
        }
    }


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


        Tensor resultTensor = new Tensor(getNewTensorName(firstTensor.name, secondTensor.name));

        // left bottom = 0
        // left top = 1
        // right bottom = 2
        // right top = 3

        if(firstTensor.existingIndexes[0] && secondTensor.existingIndexes[0]){
            String resultingIndex = Arrays.toString(firstTensor.leftBottomCoefficients) + Arrays.toString(secondTensor.leftBottomCoefficients);
            resultTensor.leftBottomCoefficients = resultingIndex.toCharArray();
        }

        if(firstTensor.existingIndexes[1] && secondTensor.existingIndexes[1]){
            String resultingIndex = Arrays.toString(firstTensor.leftTopCoefficients) + Arrays.toString(secondTensor.leftTopCoefficients);
            resultTensor.leftTopCoefficients = resultingIndex.toCharArray();
        }

        if(firstTensor.existingIndexes[2] && secondTensor.existingIndexes[2]){
            String resultingIndex = Arrays.toString(firstTensor.rightBottomCoefficients) + Arrays.toString(secondTensor.rightBottomCoefficients);
            resultTensor.rightBottomCoefficients = resultingIndex.toCharArray();
        }

        if(firstTensor.existingIndexes[3] && secondTensor.existingIndexes[3]){
            String resultingIndex = Arrays.toString(firstTensor.rightTopCoefficients) + Arrays.toString(secondTensor.rightTopCoefficients);
            resultTensor.rightTopCoefficients = resultingIndex.toCharArray();
        }

        if(firstTensor.existingIndexes[0] && !secondTensor.existingIndexes[0]){
            resultTensor.leftBottomCoefficients = firstTensor.leftBottomCoefficients;
        }

        if(!firstTensor.existingIndexes[0] && secondTensor.existingIndexes[0]){
            resultTensor.leftBottomCoefficients = secondTensor.leftBottomCoefficients;
        }

        if(firstTensor.existingIndexes[1] && !secondTensor.existingIndexes[1]){
            resultTensor.leftTopCoefficients = firstTensor.leftTopCoefficients;
        }

        if(!firstTensor.existingIndexes[1] && secondTensor.existingIndexes[1]){
            resultTensor.leftTopCoefficients = secondTensor.leftTopCoefficients;
        }

        if(firstTensor.existingIndexes[2] && !secondTensor.existingIndexes[2]){
            resultTensor.rightBottomCoefficients = firstTensor.rightBottomCoefficients;
        }

        if(!firstTensor.existingIndexes[2] && secondTensor.existingIndexes[2]){
            resultTensor.rightBottomCoefficients = secondTensor.rightBottomCoefficients;
        }

        if(firstTensor.existingIndexes[3] && !secondTensor.existingIndexes[3]){
            resultTensor.rightTopCoefficients = firstTensor.rightTopCoefficients;
        }

        if(!firstTensor.existingIndexes[3] && secondTensor.existingIndexes[3]){
            resultTensor.rightTopCoefficients = secondTensor.rightTopCoefficients;
        }

        resultTensor = convolutionTensors(resultTensor);

        return resultTensor;
    }


    @Override
    public Tensor convolutionTensors(Tensor tensor) {

        char[] sameIndexes;

        if (tensor.existingIndexes[0] && tensor.existingIndexes[1]) {

            sameIndexes = findSameIndex(tensor.leftTopCoefficients, tensor.leftBottomCoefficients);
            tensor.leftTopCoefficients = formatArray(tensor.leftTopCoefficients, sameIndexes);
            tensor.leftBottomCoefficients = formatArray(tensor.leftBottomCoefficients, sameIndexes);
            tensor.rank = (byte) (tensor.rank - sameIndexes.length*2);
        }

        if (tensor.existingIndexes[2] && tensor.existingIndexes[3]) {

            sameIndexes = findSameIndex(tensor.rightTopCoefficients, tensor.rightBottomCoefficients);
            tensor.rightTopCoefficients = formatArray(tensor.rightTopCoefficients, sameIndexes);
            tensor.rightBottomCoefficients = formatArray(tensor.rightBottomCoefficients, sameIndexes);
            tensor.rank = (byte) (tensor.rank - getSameIndexesLength(sameIndexes)*2);
        }


        return tensor;
    }


    /** CONVOLUTION BLOCK */
    private char[] formatArray(char[] coefficients, char[] sameIndexes) {



        int length = coefficients.length - getSameIndexesLength(sameIndexes);
        char[] newIndexes = new char[length];

        int newIndexesCounter = 0;

        for (int i = 0; i < coefficients.length; i++) {

            boolean ifToWrite = true;
            for (int j = 0; j < sameIndexes.length ; j++) {

                if(coefficients[i] == sameIndexes[j]){
                    ifToWrite = false;
                }


            }

            if(ifToWrite){

                newIndexes[newIndexesCounter] = coefficients[i];
                newIndexesCounter++;
            }

        }

        return newIndexes;
    }


    private int getSameIndexesLength(char[] sameIndexes) {
        int length = 0;

        for (int i = 0; i < sameIndexes.length; i++) {

            if(sameIndexes[i] != 0){
                length++;
            }
        }

        return length;
    }


    private char[] findSameIndex(char[] topCoefficients, char[] bottomCoefficients) {


        List<Character> sameSymbols = new ArrayList<Character>();

//        //choose whether the smallest array and init sameIndex length
//        if (topCoefficients.length < bottomCoefficients.length) {
//
//            sameSymbols = new char[topCoefficients.length];
//        } else {
//            sameSymbols = new char[bottomCoefficients.length];
//        }


        for (int i = 0; i < topCoefficients.length; i++) {

            char currentChar = topCoefficients[i];
            for (int j = 0; j < bottomCoefficients.length; j++) {

                if (bottomCoefficients[j] == currentChar) {
                    sameSymbols.add(currentChar);
                }

            }
        }

        char[] sameSymbolArray = new char[sameSymbols.size()];

        for(int i = 0; i < sameSymbols.size(); i++) {
            sameSymbolArray[i] = sameSymbols.get(i);
        }

        return sameSymbolArray;
    }


    /** ADDITION and SUBTRACTION BLOCK*/
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

        } else {
            conditionsArray[0] = !firstTensor.existingIndexes[0] && !secondTensor.existingIndexes[0];
        }

        if ((firstTensor.existingIndexes[1]) && (secondTensor.existingIndexes[1])) {

            if (Arrays.equals(firstTensor.leftTopCoefficients, secondTensor.leftTopCoefficients)) {

                conditionsArray[1] = true;

            } else {

                conditionsArray[1] = false;
            }

        } else {
            conditionsArray[1] = !firstTensor.existingIndexes[1] && !secondTensor.existingIndexes[1];
        }

        if ((firstTensor.existingIndexes[2]) && (secondTensor.existingIndexes[2])) {

            if (Arrays.equals(firstTensor.rightBottomCoefficients, secondTensor.rightBottomCoefficients)) {

                conditionsArray[2] = true;

            } else {

                conditionsArray[2] = false;
            }

        } else {
            conditionsArray[2] = !firstTensor.existingIndexes[2] && !secondTensor.existingIndexes[2];
        }

        if ((firstTensor.existingIndexes[3]) && (secondTensor.existingIndexes[3])) {

            if (Arrays.equals(firstTensor.rightTopCoefficients, secondTensor.rightTopCoefficients)) {

                conditionsArray[3] = true;

            } else {

                conditionsArray[3] = false;
            }

        } else {
            conditionsArray[3] = !firstTensor.existingIndexes[3] && !secondTensor.existingIndexes[3];
        }

        return conditionsArray[0] && conditionsArray[1] && conditionsArray[2] && conditionsArray[3];
    }


    /**MULTIPLICATION*/
    private char[] addTwoCharArray(char[] resultCoefficients, char[] firstCoefficients, char[] secondCoefficients) {

        return null;
    }

}
