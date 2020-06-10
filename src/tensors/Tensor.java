package tensors;

public class Tensor {

    //Name is just one big letter from english alphabet
    char name;

    //rank is the number of all indexes in tensor symbolic display way
    byte rank;

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


    public Tensor(char name) {
        this.name = name;
    }


    public void setLeftBottomCoefficients(char[] leftBottomCoefficients) {
        this.leftBottomCoefficients = leftBottomCoefficients;
        existingIndexes[0] = true;
        rank = (byte) (rank + leftBottomCoefficients.length);
    }


    public void setLeftTopCoefficients(char[] leftTopCoefficients) {
        this.leftTopCoefficients = leftTopCoefficients;
        existingIndexes[1] = true;
        rank = (byte) (rank + leftTopCoefficients.length);
    }


    public void setRightBottomCoefficients(char[] rightBottomCoefficients) {
        this.rightBottomCoefficients = rightBottomCoefficients;
        existingIndexes[2] = true;
        rank = (byte) (rank + rightBottomCoefficients.length);
    }


    public void setRightTopCoefficients(char[] rightTopCoefficients) {
        this.rightTopCoefficients = rightTopCoefficients;
        existingIndexes[3] = true;
        rank = (byte) (rank + rightTopCoefficients.length);
    }

}
