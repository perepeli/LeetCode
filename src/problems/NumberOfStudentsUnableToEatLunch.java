package problems;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroStudents = 0;
        int oneStudents = 0;

        for(int i : students) {
            if(i == 0) zeroStudents++;
            if(i == 1) oneStudents++;
        }

        for(int i : sandwiches) {
            if(i == 0) {
                zeroStudents--;
                if(zeroStudents < 0) return oneStudents;
            }
            if(i == 1) {
                oneStudents--;
                if(oneStudents < 0) return zeroStudents;
            }
        }

        return 0;
    }
}
