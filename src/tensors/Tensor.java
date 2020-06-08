package tensors;

public class Tensor {
    
    //Name is just one big letter from english alphabet
    char name;
    //rank is the number of all indexes in tensor symbolic display way 
    byte rank;

    //First array on the each side is the bottom coefficients
    //Second array on the each side is the top coefficients
    char[][] leftCoefficients;
    char[][] rightCoefficients;


    //first
    public void setLeftCoefficients(char[][] leftCoefficients) {
        this.leftCoefficients = leftCoefficients;
    }

    public void setRightCoefficients(char[][] rightCoefficients) {
        this.rightCoefficients = rightCoefficients;
    }

    public Tensor(char name, byte rank) {
        this.name = name;
        this.rank = rank;
    }

    public Tensor(char name, byte rank, char[][] leftCoefficients, char[][] rightCoefficients) {
        this.name = name;
        this.rank = rank;
        this.leftCoefficients = leftCoefficients;
        this.rightCoefficients = rightCoefficients;
    }

}
