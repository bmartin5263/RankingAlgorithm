import java.lang.Math;

public class RankingAlgorithm {

    static final int MIN = 1;    //Minimum Value
    static final int MAX = 5;    //Maximum Value
    static final int CULTURE_ITEMS = 11;
    static final int MAX_DEVIATION = (MAX-MIN) * CULTURE_ITEMS;

    private static int CultureScore(int[] company, int[] candidate) {
        /**
         * Outputs an integer (0-100) representing the percent match between
         * a company's culture profile to a candidates culture profile.
         * Order Does Not Matter.
         *
         * @param candidate array of integers in range(1-5)
         * @param company array of integers in range(1-5)
         * @returns integer (0-100)
         * @throws IllegalArgumentException
         */
        if (company.length != candidate.length)
            throw new IllegalArgumentException("Arrays Must Be Same Size");
        int deviation = 0;
        for (int i = 0; i < company.length; i++) {
            int companyVal = company[i];        // Company's Score for i'th culture aspect
            int candidateVal = candidate[i];    // Candidates's Score for i'th culture aspect
            if ((companyVal < MIN || companyVal > MAX) || (candidateVal < MIN || candidateVal > MAX))
                throw new IllegalArgumentException("Array Values Exceeds Max (" + MAX + ")or Doesn't Meet Min (" + MIN + ")");
            deviation += Math.abs(companyVal - candidateVal);
        }
        double ratio = (double)deviation / (double)MAX_DEVIATION;
        ratio = (double) Math.round(ratio * 100d) / 100d;
        int score = 100 - (int)(ratio*100);
        return score;
    }

    public static void main(String[] args) {
        // CultureScore Tests //

        // Perfect Match
        int[] companyCulture = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int[] candidateCulture = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match1");

        // Polar Opposites
        companyCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        candidateCulture = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match2");

        // Middle Match
        companyCulture = new int[] {3, 1, 4, 2, 5, 1, 4, 2, 4, 5, 1};
        candidateCulture = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match3");

        // Skew Match
        companyCulture = new int[] {3, 1, 4, 2, 5, 1, 4, 2, 4, 5, 1};
        candidateCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match4");

        // 1 Point Off Each
        companyCulture = new int[] {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        candidateCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match5");

        // Only 1 Point Off
        companyCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4};
        candidateCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match6");

        // 2 Points Off Each
        companyCulture = new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        candidateCulture = new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        score = CultureScore(candidateCulture, companyCulture);
        System.out.println(score + "% Match7");

    }

}
