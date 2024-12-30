package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Redirect implements Serializable {
    private int id;
    private String url;
    private int count;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Redirect that = (Redirect) o;

        if (count != that.count) return false;
        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "RedirectInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", count=" + count +
                '}';
    }
}
