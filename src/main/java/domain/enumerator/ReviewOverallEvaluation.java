package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewOverallEvaluation {

    EXCELLENT("Excellent"),
    GOOD("Good"),
    ACCEPTABLE("Acceptable"),
    POOR("Poor"),
    SOUND_BUT_DULL("Sound, but dull"),
    WITHOUT_OBVIOUS_SIGNIFICANCE("Without obvious significance");

    private final String name;

    private ReviewOverallEvaluation(String name) {
        this.name = name;
    }

    public static ReviewOverallEvaluation getEXCELLENT() {
        return EXCELLENT;
    }

    public static ReviewOverallEvaluation getGOOD() {
        return GOOD;
    }

    public static ReviewOverallEvaluation getACCEPTABLE() {
        return ACCEPTABLE;
    }

    public static ReviewOverallEvaluation getPOOR() {
        return POOR;
    }

    public static ReviewOverallEvaluation getSOUND_BUT_DULL() {
        return SOUND_BUT_DULL;
    }

    public static ReviewOverallEvaluation getWITHOUT_OBVIOUS_SIGNIFICANCE() {
        return WITHOUT_OBVIOUS_SIGNIFICANCE;
    }

    public String getName() {
        return name;
    }

}
