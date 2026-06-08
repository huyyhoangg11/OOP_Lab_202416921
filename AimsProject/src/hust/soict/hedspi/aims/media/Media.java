package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media other)) {
            return false;
        }

        return Float.compare(this.cost, other.cost) == 0
                && Objects.equals(this.title, other.title);
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            return 1;
        }

        String thisTitle = this.getTitle();
        String otherTitle = other.getTitle();

        int titleCompare;

        if (thisTitle == null && otherTitle == null) {
            titleCompare = 0;
        } else if (thisTitle == null) {
            titleCompare = -1;
        } else if (otherTitle == null) {
            titleCompare = 1;
        } else {
            titleCompare = thisTitle.compareTo(otherTitle);
        }

        if (titleCompare != 0) {
            return titleCompare;
        }

        return Float.compare(this.cost, other.cost);
    }
}