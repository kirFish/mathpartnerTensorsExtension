package tensors;

public class Tensor {

    //Name is just one big letter from english alphabet
    char name;


    // left bottom = 0
    // left top = 1
    // right bottom = 2
    // right top = 3
    boolean[] existingIndexes = new boolean[4];

    //First array on the each side is the bottom coefficients
    //Second array on the each side is the top coefficients
    char[] leftBottomCoefficients;
    char[] leftTopCoefficients;
    char[] rightBottomCoefficients;
    char[] rightTopCoefficients;


    public Tensor(char name, byte rank) {
        this.name = name;
        this.rank = rank;
    }


    // if tensor has only right or only left coefficient than others should be set to zero
    public Tensor(char name, char[] leftBottomCoefficients, char[] leftTopCoefficients, char[] rightBottomCoefficients, char[] rightTopCoefficients, byte rank) {
        this.name = name;
        this.rank = rank;
        this.leftBottomCoefficients = leftBottomCoefficients;
        this.leftTopCoefficients = leftTopCoefficients;
        this.rightBottomCoefficients = rightBottomCoefficients;
        this.rightTopCoefficients = rightTopCoefficients;
    }


    //rank is the number of all indexes in tensor symbolic display way
    byte rank;

    //for convenience to work with
    public void setLeftBottomCoefficients(char[] leftBottomCoefficients) {
        this.leftBottomCoefficients = leftBottomCoefficients;
        existingIndexes[0] = true;
    }

    //for convenience to work with
    public void setLeftTopCoefficients(char[] leftTopCoefficients) {
        this.leftTopCoefficients = leftTopCoefficients;
        existingIndexes[1] = true;
    }

    //for convenience to work with
    public void setRightBottomCoefficients(char[] rightBottomCoefficients) {
        this.rightBottomCoefficients = rightBottomCoefficients;
        existingIndexes[2] = true;
    }


    //for convenience to work with
    public void setRightTopCoefficients(char[] rightTopCoefficients) {
        this.rightTopCoefficients = rightTopCoefficients;
        existingIndexes[3] = true;
    }

}
