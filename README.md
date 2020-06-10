# Software ControlMEI

This software was will development to Java SE and implements is the sections down:
- person screen: customer, supplier, user
- Product screen: product, category, product section, brand, product measures
- Simple sale screen


## Windows of software ControlMEI

Framework, library and CASE:
- Java SE
- EclipseLink
- JCalendar
- JasperStudio (iReport)
- Database MySQL And Apache Derby for embedded

### Information
The objects will send the data to generic class the database.

`````java
public abstract class Generic<T extends InterValueId> {

    public static EntityManager Factory() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlup");
        return factory.createEntityManager();

    }

    public T save(T t) {
        EntityManager em = factory.Generic.Factory();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);
            } else {
                if (!em.contains(t)) {
                    if (em.find(t.getClass(), t.getId()) == null) {
                        throw new Exception("Register not found!");
                    }

                }

                em.merge(t);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insert register: " + e.getMessage());
            if (e.getMessage().contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Duplicate key: " + t.getClass().getSimpleName().toUpperCase() + " with not permission.\nCheck and try again.");
            }
            em.getTransaction().rollback();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return t;
    }

    public void delete(Class<T> c, Integer id) {
        EntityManager em = Generic.Factory();
        T delete = em.find(c, id);

        try {
            int key = JOptionPane.showConfirmDialog(null, "This action will removing definitely object it database.\nWant continue?", "DELETAR DADOS DO BANCO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (key != JOptionPane.YES_OPTION) {

                return;
            }
            em.getTransaction().begin();
            em.remove(delete);
            em.getTransaction().commit();

        } catch (HeadlessException e) {
            System.out.println("You do not remove product: error some remove -> " + e.getMessage());
        }

    }

    public T find(Class<T> c, Integer id) {
        EntityManager em = Generic.Factory();
        T find;
        try {
            find = em.find(c, id);

        } catch (Exception e) {
            find = null;
        }

        return find;
    }

}
`````

<a href="https://imgur.com/SGdmwvE"><img src="https://i.imgur.com/SGdmwvE.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/NzfobE7"><img src="https://i.imgur.com/NzfobE7h.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/y4taqVV"><img src="https://i.imgur.com/y4taqVVh.png" title="source: imgur.com" /></a>

<a href="https://imgur.com/FoErBc2"><img src="https://i.imgur.com/FoErBc2h.png" title="source: imgur.com" /></a>
