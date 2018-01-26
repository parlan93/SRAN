package helper;

/**
 *
 * @author Bartłomiej Skibiński
 */
public class ViewList {
    
    public static final ViewItem HOME = new ViewItem("Strona Główna", "fa-home", "/home");
    public static final ViewItem LOGIN = new ViewItem("Logowanie", "fa-unlock-alt", "/login");
    public static final ViewItem REGISTER = new ViewItem("Rejestracja", "fa-user-plus", "/register");
    public static final ViewItem ERROR403 = new ViewItem("Brak uprawnień!", "fa-frown-o", "/403");
    
    public static final ViewItem REVIEWER_DASHBOARD = new ViewItem("Panel Recenzenta", "fa-dashboard", "/reviewer");
    public static final ViewItem AUTHOR_DASHBOARD = new ViewItem("Panel Autora", "fa-dashboard", "/author");
    public static final ViewItem ADMIN_DASHBOARD = new ViewItem("Panel Administratora", "fa-dashboard", "/admin");
    
    public static final ViewItem REVIEWER_REVIEW_FORM = new ViewItem("Recenzja artykułu", "fa-meh-o", "/reviewer/review");
    public static final ViewItem REVIEWER_REVIEW_SAVE = new ViewItem("Zapis", "fa-meh-o", "/reviewer/review/save");
    
    public static final ViewItem AUTHOR_ARTICLE_DETAILS = new ViewItem("Artykuł", "fa-file-o", "/author/details");
    public static final ViewItem AUTHOR_ARTICLE_ADD = new ViewItem("Dodaj artykuł", "fa-plus-square", "/author/add-article");
    public static final ViewItem AUTHOR_ARTICLE_REVISION = new ViewItem("Dodaj poprawioną wersję artykułu", "fa-plus-square", "/author/add-revised-article");
    
    public static final ViewItem ADMIN_USER_DETAILS = new ViewItem("Informacje o Użytkowniku", "fa-user", "/admin/users");
    public static final ViewItem ADMIN_USER_ROLE = new ViewItem("Ranga Użytkownika", "fa-id-card-o", "/admin/users/role");
    public static final ViewItem ADMIN_ARTICLE_DETAILS = new ViewItem("Informacje o artyule", "fa-file-o", "/admin/articles");
    public static final ViewItem ADMIN_ARTICLE_REVIEWERS = new ViewItem("Recenzenci", "fa-users", "/admin/articles/reviewers");
    public static final ViewItem ADMIN_ARTICLE_EDIT = new ViewItem("Edycja artykułu", "fa-file-o", "/admin/articles/edit");
}
