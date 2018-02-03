package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewFinalRecommendation {

    ACCEPT_WITH_NO_CHANGES("Accept with no changes"),
    ACCEPT_AFTER_MINOR_REVISIONS("Accept after minor revisions (without 2nd review"),
    REVISE_AND_RESUBMIT("Revise and resubmit"),
    REJECT("Reject");

    private final String name;

    private ReviewFinalRecommendation(String name) {
        this.name = name;
    }

    public static ReviewFinalRecommendation getACCEPT_WITH_NO_CHANGES() {
        return ACCEPT_WITH_NO_CHANGES;
    }

    public static ReviewFinalRecommendation getACCEPT_AFTER_MINOR_REVISIONS() {
        return ACCEPT_AFTER_MINOR_REVISIONS;
    }

    public static ReviewFinalRecommendation getREVISE_AND_RESUBMIT() {
        return REVISE_AND_RESUBMIT;
    }

    public static ReviewFinalRecommendation getREJECT() {
        return REJECT;
    }

    public String getName() {
        return name;
    }

}
