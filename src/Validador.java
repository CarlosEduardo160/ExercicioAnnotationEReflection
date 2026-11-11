import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Validador {
    public void validarUsuario(Object obj) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields){
            if(field.isAnnotationPresent(NaoVazio.class)){
                Field campoNome = obj.getClass().getDeclaredField("nome");
                campoNome.setAccessible(true);
                Object valor = campoNome.get(obj);
                String titulo = (String) valor;

                if (titulo == null || titulo.isEmpty()){
                    System.out.println("O campo 'nome' não pode estar vázio");
                }
            } else if (field.isAnnotationPresent(Tamanho.class)) {
                Field campoSenha = obj.getClass().getDeclaredField("senha");
                campoSenha.setAccessible(true);
                Object valor = campoSenha.get(obj);
                    if(valor == null){
                        System.out.println("O campo 'senha' não pode estar vázio");
                    } else {
                        String tamanho = (String) valor;

                        if (tamanho.length() < 8 || tamanho.length() > 20) {
                            System.out.println("O tamanho da senha deve estar entre 8 e 20.");
                        }
                    }
            }
        }
    }
}
