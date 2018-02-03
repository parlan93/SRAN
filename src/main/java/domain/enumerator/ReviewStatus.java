package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ReviewStatus {

    TO_REVIEW("To review", "Do recenzji"),
    TO_REVIEW_ONCE_MORE("To review once more", "Do ponownej recenzji"),
    POSITIVE("Positive", "Pozytywna"),
    NEGATIVE("Negative", "Negatywna"),
    AMBIGUOUS("Ambiguous", "Niejednoznaczny");
    
    private final String enName;
    private final String plName;

    private ReviewStatus(String enName, String plName) {
        this.enName = enName;
        this.plName = plName;
    }

    public static ReviewStatus getTO_REVIEW() {
        return TO_REVIEW;
    }

    public static ReviewStatus getTO_REVIEW_ONCE_MORE() {
        return TO_REVIEW_ONCE_MORE;
    }

    public static ReviewStatus getPOSITIVE() {
        return POSITIVE;
    }

    public static ReviewStatus getNEGATIVE() {
        return NEGATIVE;
    }

    public static ReviewStatus getAMBIGUOUS() {
        return AMBIGUOUS;
    }

    public String getEnName() {
        return enName;
    }

    public String getPlName() {
        return plName;
    }

}
