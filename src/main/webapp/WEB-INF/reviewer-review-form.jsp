<%-- 
    Document   : reviewer-review-form
    Created on : 2018-01-24, 17:24:28
    Author     : Bartłomiej Skibiński
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <%@include file="jspf/head.jspf" %>
    <body>
        <%@include file="jspf/header.jspf" %>
        <section class="section">
            <div class="container-fluid">

                <%@include file="jspf/title.jspf" %>

                <div class="row row-content">
                    <div class="col-xs-12">

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Informacje o artykule
                                    </div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label>Tytuł</label>
                                            <p class="form-control-static">${article.title}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Status artykułu</label>
                                            <p class="form-control-static">${article.articleStatus.plName}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="/reviewer/review/save" method="post">

                                    <div class="form-group">
                                        <label>Scope</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-scope" value="OF_GENERAL_RELEVANCE" checked="" />Of general relevance
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-scope" value="RELEVANT_TO_THE_FIELD_OF_DSP" />Relevant to the field of DSP
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-scope" value="VERY_SPECIALISED" />Very specialised
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-scope" value="OUT_OF_SCOPE" />Out of scope
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Content</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="NEW_TECHNIQUE_OR_THEORY" checked="" />New technique or theory
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="NEW_APPLICATION_OF_KNOWN_CONCEPTS" />New application of known concepts
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="CONFIRMATION_OF_KNOWN_TECHNIQUES" />Confirmation of known techniques
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="REPETITION_OF_KNOWN_MATERIAL" />Repetition of known material
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="TOO_SPECULATIVE_OR_THEORETICAL" />Too speculative or theoretical
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="TOO_TECHNICAL" />Too technical
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-content" value="TOO_PRELIMINARY" />Too preliminary
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Conclusion Drawn</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-conclusion-drawn" value="ADEQUATE" checked="" />Adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-conclusion-drawn" value="NOT_JUSTIFIED" />Not justified
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-conclusion-drawn" value="SUFFER_FROM_SUBSTANTIAL_OMISSIONS" />Suffer from substantial omissions
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-conclusion-drawn" value="SUFFER_FROM_LOOSE_GENERALISATIONS" />Suffer from loose generalisations
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Presentation</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="ADEQUATE" checked="" />Adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="TOO_BRIEF_FOR_CLARITY" />Too brief for clarity
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="TOO_COMPREHENSIVE_SHOULD_BE_SHORTENED" />Too comprehensive, should be shortended
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="GENERAL_ORGANISATION_UNSUITABLE" />General organisation unsuitable
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="BADLY_WRITTEN_HARDLY_READABLE" />Badly written, hardly readable
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-presentation" value="CONTAINS_IRRELEVANT_MATERIAL" />Contains irrelevant material
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Language</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-language" value="SATISFACTORY" checked="" />Satisfactiory
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-language" value="NEEDS_CORRECTIONS" />Needs corrections
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-language" value="NEEDS_SUBSTANTIAL_REVISION_OR_REWRITING" />Needs substantial revision or rewriting
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Abstract</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-abstract" value="CLEAR_AND_ADEQUATE" checked="" />Clear and adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-abstract" value="SHOULD_BE_REWRITTEN" />Should be rewritting (or missing)
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Illustrations</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-illustrations" value="ADEQUATE" checked="" />Adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-illustrations" value="INADEQUATE_TECHNICAL_QUALITY" />Inadequate technical quality
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-illustrations" value="NON_VERY_INFORMATIVE" />Non very informative
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-illustrations" value="SOME_MAY_BE_OMMITED" />Some may be omitted (see Sec. III)
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-illustrations" value="MOORE_SHOULD_BE_ADDED" />More should be added (see Sec. III)
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Tables</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-tables" value="ADEQUATE" checked="" />Adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-tables" value="SHOULD_BE_REARRANGED_TO_IMPROVE_CLARITY" />Should be rearranged to improve clarity
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-tables" value="SOME_MAY_BE_OMITTED" />Some may be omitted
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-tables" value="MORE_SHOULD_BE_ADDED" />More should be added (see Sec. III)
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Abbreviations, Formulae, Units</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-afu" value="CONFORM_TO_ACCEPTED_FORM" checked="" />Conform to accepted from
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-afu" value="SHOULD_BE_CHANGED" />Should be changed
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-afu" value="SHOULD_BE_EXPLAINED" />Should be explained
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Literature References</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-literature-references" value="ADEQUATE" checked="" />Adequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-literature-references" value="INADEQUATE" />Inadequate
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-literature-references" value="SOME_MAY_BE_OMITTED" />Some may be omitted
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-literature-references" value="MORE_SHOULD_BE_ADDED" />More should be added (see Sec. III)
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Overall Evaluation</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="EXCELLENT" checked="" />Excellent
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="GOOD" />Good
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="ACCEPTABLE" />Acceptable
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="POOR" />Poor
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="SOUND_BUT_DULL" />Sound, but dull
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-overall-evaluation" value="WITHOUT_OBVIOUS_SIGNIFICANCE" />Without obvious significance
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Final Recommendation</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-final-recommendation" value="ACCEPT_WITH_NO_CHANGES" checked="" />Accept with no changes
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-final-recommendation" value="ACCEPT_AFTER_MINOR_REVISIONS" />Accept after minor revisions (without 2nd review
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-final-recommendation" value="REVISE_AND_RESUBMIT" />Revise and resubmit
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-final-recommendation" value="REJECT" />Reject
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Opis i uwagi</label>
                                        <textarea class="form-control" rows="5" name="description" id="description"></textarea>
                                    </div>

                                    <input type="hidden" name="article-id" value="${article.articleId}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <button type="submit" value="submit" class="btn btn-success">Oceń</button>
                                    <button type="reset" value="reset" class="btn btn-primary">Zresetuj</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>