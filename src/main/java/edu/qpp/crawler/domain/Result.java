package edu.qpp.crawler.domain;

import edu.qpp.crawler.config.Constants;

import javax.persistence.*;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Pattern;
    import javax.validation.constraints.Size;

/**
 * Created by xirui on 2017/4/5.
 */
@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    @Pattern(regexp = Constants.LOGIN_REGEX)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(length = 256, unique = true, nullable = false)
    private String url;

    @Size(min = 1, max = 10240)
    @Column(length = 10240)
    private String digest;

    @Size(min = 1, max = 20)
    @Column(length = 20,unique = true,nullable = false)
    private String theme;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (id != null ? !id.equals(result.id) : result.id != null) return false;
        if (url != null ? !url.equals(result.url) : result.url != null) return false;
        if (digest != null ? digest.equals(result.digest) : result.digest != null) return true;
        return theme != null ? theme.equals(result.theme) : result.theme == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (digest != null ? digest.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        return result;
    }
}
