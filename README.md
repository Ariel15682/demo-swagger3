Se crea un pequeño proyecto a partir de una clase Plant, en la cual se implementa
Lombok (@Data) para generar constructores y metodos setter y getter entre otras 
cosas. La finalidad del mismo es implementar la APi de Swagger en su v3 sobre la
version de SpringBoot 3 con Jakarta. Se adjuta una imagen/captura con la generacion
de la documentacion. La clase controller solo disponia del metodo "getAll()". 
En la clase servicio se hace uso de un Logger para mostrar los errores que ocurren.
Se implemento tambien una interfaz repositorio para hacer uso de la persistencia
en una BD H2 en memoria ya que la aplicacion original solo solicitaba los datos a
una lista.
Se insertaron 3 plantas de prueba en la clase main