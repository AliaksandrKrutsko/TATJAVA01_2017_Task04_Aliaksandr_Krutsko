package bean;


import java.io.Serializable;

public class News implements Serializable {

    private String category;
    private String name;
    private String content;


    public News() {


    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + category.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + content.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        News other = (News) obj;
        if (category != other.category)
            return false;
        if (name != other.name)
            return false;
        if (content != other.content)
            return false;
        return true;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {

        this.name = name;

    }

    public void setCategory(String category) {

        this.category = category;

    }

    public void setContent(String content) {

        this.content = content;

    }

    public String toString() {
        return "name: " + this.name + ", "
                + "category: " + this.category + ", " + "content: "
                + this.content;
    }


}
