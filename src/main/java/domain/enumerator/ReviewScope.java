package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewScope {

    OF_GENERAL_RELEVANCE("Of general relevance"),
    RELEVANT_TO_THE_FIELD_OF_DSP("Relevant to the field of DSP"),
    VERY_SPECIALISED("Very specialised"),
    OUT_OF_SCOPE("Out of scope");

    private final String name;

    private ReviewScope(String name) {
        this.name = name;
    }

    public static ReviewScope getOF_GENERAL_RELEVANCE() {
        return OF_GENERAL_RELEVANCE;
    }

    public static ReviewScope getRELEVANT_TO_THE_FIELD_OF_DSP() {
        return RELEVANT_TO_THE_FIELD_OF_DSP;
    }

    public static ReviewScope getVERY_SPECIALISED() {
        return VERY_SPECIALISED;
    }

    public static ReviewScope getOUT_OF_SCOPE() {
        return OUT_OF_SCOPE;
    }

    public String getName() {
        return name;
    }

}
