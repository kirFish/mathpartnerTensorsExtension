package tensors;

import java.util.Arrays;

public class Printer {

    public static void printTensor(Tensor tensor){

        System.out.println("\n");

        //Every tensor has  it's name and rank
        System.out.println("The tensor has a name:" + tensor.name);
        System.out.println("The rank of tensor is: " + tensor.rank);

        //left bottom index
        if(tensor.leftCoefficients[0] !=null){

            System.out.println("Left bottom indexes:" + Arrays.toString(tensor.leftCoefficients[0]));
        }

        //left top index
        if(tensor.leftCoefficients[1] != null) {
            System.out.println("Left top indexes:" + Arrays.toString(tensor.leftCoefficients[1]));
        }


        //right bottom index
        if(tensor.rightCoefficients[0] != null){
            System.out.println("Right bottom indexes:" + Arrays.toString(tensor.rightCoefficients[0]));
         }

        //right top index
        if(tensor.rightCoefficients[1] != null) {
            System.out.println("Right top indexes:" + Arrays.toString(tensor.rightCoefficients[1]));
        }

        System.out.println("\n");
    }

}
