package tensors;

import java.util.Arrays;

public class Printer {

    public static void printTensor(Tensor tensor){

        System.out.println("\n");

        //Every tensor has  it's name and rank
        System.out.println("The tensor has a name:" + tensor.name);
        System.out.println("The rank of tensor is: " + tensor.rank);

        //left bottom index
        if(tensor.existingIndexes[0]){

            System.out.println("Left bottom indexes:" + Arrays.toString(tensor.leftBottomCoefficients));
        }

        //left top index
        if(tensor.existingIndexes[0]) {
            System.out.println("Left top indexes:" + Arrays.toString(tensor.leftTopCoefficients));
        }


        //right bottom index
        if(tensor.existingIndexes[0]){
            System.out.println("Right bottom indexes:" + Arrays.toString(tensor.rightBottomCoefficients));
         }

        //right top index
        if(tensor.existingIndexes[0]) {
            System.out.println("Right top indexes:" + Arrays.toString(tensor.rightTopCoefficients));
        }

        System.out.println("\n");
    }

}
