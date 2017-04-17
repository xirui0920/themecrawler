package edu.qpp.crawler.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by xirui on 2017/4/5.
 */
@Entity
@Table(name = "theme_mapping")
public class ThemeMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 20)
    @Column(length = 20)
    private String theme;

    @Column()
    private Date lasttime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThemeMapping that = (ThemeMapping) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (theme != null ? !theme.equals(that.theme) : that.theme != null) return false;
        return lasttime != null ? lasttime.equals(that.lasttime) : that.lasttime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (lasttime != null ? lasttime.hashCode() : 0);
        return result;
    }
}
