
package Model;

public class CategoryUser extends User{
    
    private int idCategory;
    private String nameCategory;

    public CategoryUser(int idCategory, String nameCategory, int id, String name, String email, String password, String photo) {
        super(id, name, email, password, photo);
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public CategoryUser() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    
    @Override
    public String toString() {
        return "CategoryUser{" + "id = " +super.getId()+ ", name ="+super.getName()+", email ="+super.getEmail()+", idCategory=" + idCategory + '}';
    }
}
