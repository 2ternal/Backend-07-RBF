package rbf4.article;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {

    private Map<Long, Article> articles = new HashMap<>();

    @Getter
    private Long sequence = 0L;

    public Article save(Article article) {
        sequence++;

        article.setId(sequence);
        articles.put(article.getId(), article);

        return article;
    }

    public Article findById(Long id) {
        return articles.get(id);
    }

    public void remove(Long id) {
        articles.remove(id);
    }
}
