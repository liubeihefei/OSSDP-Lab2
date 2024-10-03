import static org.junit.jupiter.api.Assertions.*;

class L2022211846_5_Test {
    Solution5 instance;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        instance = new Solution5();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void numSubseq() {
        int[] arrayOne = {3,5,6,7};
        int targetOne = 9;
        assertEquals(instance.numSubseq(arrayOne, targetOne), 4);

        int[] arrayTwo = {3,3,6,8};
        int targetTwo = 10;
        assertEquals(instance.numSubseq(arrayTwo, targetTwo), 6);

        int[] arrayThree = {2,3,3,4,6,7};
        int targetThree = 12;
        assertEquals(instance.numSubseq(arrayThree, targetThree), 61);
    }

    @org.junit.jupiter.api.Test
    void binarySearch() {
        int[] array = {1, 2, 2, 3, 6, 7};

        int targetOne = 3;
        assertEquals(instance.binarySearch(array, targetOne), 3);

        int targetTwo = 8;
        assertEquals(instance.binarySearch(array, targetTwo), 5);

        int targetThree = 5;
        assertEquals(instance.binarySearch(array, targetThree), 3);
    }
}