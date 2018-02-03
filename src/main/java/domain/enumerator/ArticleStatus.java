package domain.enumerator;

/**
 *
 * @author Bartłomiej Skibiński
 */
public enum ArticleStatus {

    NEW("New", "Nowy"),
    WAITING_FOR_REVIEW("Waiting for review", "Czeka na recenzję"),
    REVIEWED_ACCEPTED("Reviewed accepted", "Oceniony przyjęty"),
    REVIEWED_TO_CORRECT("Reviewed to correct", "Oceniony do poprawy"),
    REVIEWED_DECLINED("Reviewed declined", "Oceniony odrzucony"),
    WAITING_FOR_REVIEW_ONCE_MORE("Waiting for review once more", "Czeka na ponowną recenzję");

    private final String enName;
    private final String plName;

    private ArticleStatus(String enName, String plName) {
        this.enName = enName;
        this.plName = plName;
    }

    public static ArticleStatus getNEW() {
        return NEW;
    }

    public static ArticleStatus getWAITING_FOR_REVIEW() {
        return WAITING_FOR_REVIEW;
    }

    public static ArticleStatus getREVIEWED_ACCEPTED() {
        return REVIEWED_ACCEPTED;
    }

    public static ArticleStatus getREVIEWED_TO_CORRECT() {
        return REVIEWED_TO_CORRECT;
    }

    public static ArticleStatus getREVIEWED_DECLINED() {
        return REVIEWED_DECLINED;
    }

    public static ArticleStatus getWAITING_FOR_REVIEW_ONCE_MORE() {
        return WAITING_FOR_REVIEW_ONCE_MORE;
    }

    public String getEnName() {
        return enName;
    }

    public String getPlName() {
        return plName;
    }

}
