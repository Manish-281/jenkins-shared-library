def call(String imgname){
   sh "docker build -t ${imgname} ."
}
