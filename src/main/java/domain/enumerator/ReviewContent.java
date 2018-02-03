package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewContent {

    NEW_TECHNIQUE_OR_THEORY("New technique or theory"),
    NEW_APPLICATION_OF_KNOWN_CONCEPTS("New application of known concepts"),
    CONFIRMATION_OF_KNOWN_TECHNIQUES("Confirmation of known techniques"),
    REPETITION_OF_KNOWN_MATERIAL("Repetition of known material"),
    TOO_SPECULATIVE_OR_THEORETICAL("Too speculative or theoretical"),
    TOO_TECHNICAL("Too technical"),
    TOO_PRELIMINARY("Too preliminary");

    private final String name;

    private ReviewContent(String name) {
        this.name = name;
    }

    public static ReviewContent getNEW_TECHNIQUE_OR_THEORY() {
        return NEW_TECHNIQUE_OR_THEORY;
    }

    public static ReviewContent getNEW_APPLICATION_OF_KNOWN_CONCEPTS() {
        return NEW_APPLICATION_OF_KNOWN_CONCEPTS;
    }

    public static ReviewContent getCONFIRMATION_OF_KNOWN_TECHNIQUES() {
        return CONFIRMATION_OF_KNOWN_TECHNIQUES;
    }

    public static ReviewContent getREPETITION_OF_KNOWN_MATERIAL() {
        return REPETITION_OF_KNOWN_MATERIAL;
    }

    public static ReviewContent getTOO_SPECULATIVE_OR_THEORETICAL() {
        return TOO_SPECULATIVE_OR_THEORETICAL;
    }

    public static ReviewContent getTOO_TECHNICAL() {
        return TOO_TECHNICAL;
    }

    public static ReviewContent getTOO_PRELIMINARY() {
        return TOO_PRELIMINARY;
    }

    public String getName() {
        return name;
    }

}
