package impl;

import entity.uf.State;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplState extends factory.Generic<State> {

    private static State uf;

    public List<State> findAll() {
        EntityManager em = factory.Generic.Factory();
        List<State> estado;
        try {
            Query query = em.createNamedQuery("State.findAll");
            estado = query.getResultList();
        } catch (Exception e) {
            estado = new ArrayList();
        }

        return estado;
    }

    public static void updateState() {
        ImplState imp = new ImplState();
        uf = new State();
        String value
                = "12, 'Acre', 'AC', 1 \n"
                + "27, 'Alagoas', 'AL', 2 \n"
                + "16, 'Amapá', 'AP', 1 \n"
                + "13, 'Amazonas', 'AM', 1 \n"
                + "29, 'Bahia', 'BA', 2 \n"
                + "23, 'Ceará', 'CE', 2 \n"
                + "53, 'Distrito Federal', 'DF', 5 \n"
                + "32, 'Espírito Santo', 'ES', 3 \n"
                + "52, 'Goiás', 'GO', 5 \n"
                + "21, 'Maranhão', 'MA', 2 \n"
                + "51, 'Mato Grosso', 'MT', 5 \n"
                + "50, 'Mato Grosso do Sul', 'MS', 5 \n"
                + "31, 'Minas Gerais', 'MG', 3 \n"
                + "15, 'Pará', 'PA', 1 \n"
                + "25, 'Paraíba', 'PB', 2 \n"
                + "41, 'Paraná', 'PR', 4 \n"
                + "26, 'Pernambuco', 'PE', 2 \n"
                + "22, 'Piauí', 'PI', 2 \n"
                + "33, 'Rio de Janeiro', 'RJ', 3 \n"
                + "24, 'Rio Grande do Norte', 'RN', 2 \n"
                + "43, 'Rio Grande do Sul', 'RS', 4 \n"
                + "11, 'Rondônia', 'RO', 1 \n"
                + "14, 'Roraima', 'RR', 1 \n"
                + "42, 'Santa Catarina', 'SC', 4 \n"
                + "35, 'São Paulo', 'SP', 3 \n"
                + "28, 'Sergipe', 'SE', 2 \n"
                + "17, 'Tocantins', 'TO', 1 ";

        String[] split = value.split("\n");

        for (String v : split) {
            String[] set = v.split(",");
//            uf.setCodigouf(null);
            uf.setNome(set[1].trim().replace("'", ""));
            uf.setUf(set[2].trim().replace("'", ""));
            uf.setRegiao(Integer.parseInt(set[3].trim()));
            imp.save(uf);
        }
        
        if (imp.findAll().size() <= 27) {
            updateState(); // 
        }

    }

}
