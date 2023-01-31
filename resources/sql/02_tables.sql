
DROP TABLE IF EXISTS `origin_sites`;
DROP TABLE IF EXISTS `note_template`;
DROP TABLE IF EXISTS `candidates`;
DROP TABLE IF EXISTS `course_resume`;
DROP TABLE IF EXISTS `coursepage`;
DROP TABLE IF EXISTS `surveyinterviews`;
DROP TABLE IF EXISTS `interviews`;
DROP TABLE IF EXISTS `candidate_states`;
DROP TABLE IF EXISTS `surveyreplies`;
DROP TABLE IF EXISTS `surveyquestions`;
DROP TABLE IF EXISTS `questions`;
DROP TABLE IF EXISTS `usersurveytoken`;
DROP TABLE IF EXISTS `surveys`;
DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `itconsultants`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `roles`;





CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `level` (`level`)
) ;

INSERT INTO `roles` VALUES (1,'admin','administrator',0),(2,'developer','developer',10),(3,'permanent, external consultant','dipendente, attualmente impiegato in attività di consulenza esterna',50),(4,'java course candidate','candidato a partecipare a corso java',90),(5,'guest','guest',100);


CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `regdate` datetime NOT NULL,
  `role` int(11) NOT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueEmail` (`email`),
  KEY `role` (`role`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role`) REFERENCES `roles` (`level`)
);

INSERT INTO `users` VALUES (1,'1@2.3','$2a$10$FKozujcHmWdulk6naR/XveW3x46hWPnRY2S/cyI/XhmjZZEOwz.bW','Markus','Red','1979-10-12','2019-02-12 16:56:05',10,NULL,NULL,0);

CREATE TABLE `origin_sites` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `label` (`label`)
);

INSERT INTO `origin_sites` VALUES (1,'infojobs.it','http://infojobs.it','aaa'),(2,'linkedin.com','linkedin.com','linkedin.com'),(3,'monster.it','monster.it','monster.it');


CREATE TABLE `surveys` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) NOT NULL,
  `time` bigint(20) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `surveys` VALUES (1,'Questionario Java cap. 1',20,'Questionario Java OCA Capitolo 1'),(2,'Questionario Java cap. 2',20,'Questionario Java OCA Capitolo 2'),(3,'Questionario candidati corso Java+Web',20,'Questionario di valutazione per candidati corso Full Stack Develpment Java+Web'),(4,'Questionario candidati corso Java+Web 2',20,'Questionario di valutazione per candidati corso Full Stack Develpment Java+Web - contiene le stesse domande del questionario full stack java n.1 ma in ordine differente'),(5,'Java Teaching Unit 1 Survey',10,'End Java Teaching Unit 1 Survey'),(6,'Questionario Java cap. 3',20,'Questionario Java OCA Capitolo 3');


CREATE TABLE `note_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ;
INSERT INTO `note_template` VALUES (1,'test title note 1', 'test content note 1');
--INSERT INTO `note_template` VALUES (2, 'test title note 2', 'test content note 1');
--INSERT INTO `note_template` (title, content) VALUES ('test title note 2', 'test content note 1');
--INSERT INTO `note_template` (title, content) VALUES ('test title note 3', 'test content note 3');
--select * from note_template;


CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label` varchar(500) NOT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `ansa` varchar(255) DEFAULT NULL,
  `ansb` varchar(255) DEFAULT NULL,
  `ansc` varchar(255) DEFAULT NULL,
  `ansd` varchar(255) DEFAULT NULL,
  `anse` varchar(255) DEFAULT NULL,
  `ansf` varchar(255) DEFAULT NULL,
  `ansg` varchar(255) DEFAULT NULL,
  `ansh` varchar(255) DEFAULT NULL,
  `cansa` bit(1) DEFAULT NULL,
  `cansb` bit(1) DEFAULT NULL,
  `cansc` bit(1) DEFAULT NULL,
  `cansd` bit(1) DEFAULT NULL,
  `canse` bit(1) DEFAULT NULL,
  `cansf` bit(1) DEFAULT NULL,
  `cansg` bit(1) DEFAULT NULL,
  `cansh` bit(1) DEFAULT NULL,
  `full_answer` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `questions` VALUES (1,'Which of the following are valid Java identifiers?','(Choose all that apply)','A$B','_helloWorld','true','java.lang','Public','1980_s',NULL,NULL,'','','\0','\0','','\0',NULL,NULL,'A, B, E. Option A is valid because you can use the dollar sign in identifiers. Option B is\nvalid because you can use an underscore in identifiers. Option C is not a valid identifier\nbecause true is a Java reserved word. Option D is not valid because the dot (.) is not\nallowed in identifiers. Option E is valid because Java is case sensitive, so Public is not\na reserved word and therefore a valid identifier. Option F is not valid because the first\ncharacter is not a letter, $, or _.'),(2,'Which of the following are true?','(Choose all that apply)','A local variable of type boolean defaults to null.','A local variable of type float defaults to 0.','A local variable of type Object defaults to null.','A local variable of type boolean defaults to false.','A local variable of type boolean defaults to true.','A local variable of type float defaults to 0.0','None of the above.',NULL,'\0','\0','\0','\0','\0','\0','',NULL,' G. Option G is correct because local variables do not get assigned default values. The code fails to compile if a local variable is not explicitly initialized. If this question were about instance variables, options D and F would be correct. A boolean primitive defaults to false and a float primitive defaults to 0.0. '),(3,'Which of the following legally fill in the blank so you can run the main() method from the command line?','(Choose all that apply)','String[] _names','String[] 123','String abc[]','String _Names[]','String.. $n','String names','None of the above',NULL,'\0','\0','\0','\0','','\0','\0',NULL,'E. Option E is the canonical main() method signature. You need to memorize it.\nOption A is incorrect because the main() method must be public. Options B and F\nare incorrect because the main() method must have a void return type. Option C is\nincorrect because the main() method must be static. Option D is incorrect because the\nmain() method must be named main.'),(4,'Which of the following are legal entry point methods that can be run from the command line?','(Choose all that apply)','private static void main(String[] args)','public static final main(String[] args)','public void main(String[] args)','public static void test(String[] args)','public static void main(String[] args)','public static main(String[] args)','None of the above.',NULL,'\0','\0','\0','\0','','\0','\0',NULL,'Option E is the canonical main() method signature. You need to memorize it. Option A is incorrect because the main() method must be public. Options B and F\nare incorrect because the main() method must have a void return type. Option C is incorrect because the main() method must be static. Option D is incorrect because the main() method must be named main.'),(5,'Gived the following classes, what is the maximum number of imports that can be removed\n       and have the code still compile?','package aquarium;\n       import java.lang.*;\n       import java.lang.System;\n       import aquarium.Water;\n       import aquarium.*;\n       public class Tank{\n       	public void print(Water water){\n       	  System.out.println(water);\n       	  }}','0','1','2','3','4','Does not compile.',NULL,NULL,'\0','\0','\0','\0','','\0',NULL,NULL,'E. The first two imports can be removed because java.lang is automatically imported. \n       The second two imports can be removed because Tank and Water are in the same \n       package, making the correct answer E. If Tank and Water were in different packages, one of \n       these two imports could be removed. In that case, the answer would be option D. '),(6,'Given the following class, which of the following calls print out Blue Jay?','(Choose all that apply)	\n                       	public class BirdDisplay { \n                       		public static void main(String[] name) {\n                       			System.out.println(name[1]);\n                       	} }','java BirdDisplay Sparrow Blue Jay','java BirdDisplay Sparrow \"Blue Jay\"','java BirdDisplay Blue Jay Sparrow','java BirdDisplay \"Blue Jay\" Sparrow','java BirdDisplay.class Sparrow \"Blue Jay\" ','java BirdDisplay.class \"Blue Jay\" Sparrow','Does not compile.',NULL,'\0','','\0','\0','\0','\0','\0',NULL,'B. Option B is correct because arrays start counting from zero and strings with spaces\nmust be in quotes. Option A is incorrect because it outputs Blue. C is incorrect because\nit outputs Jay. Option D is incorrect because it outputs Sparrow. Options E and F are\nincorrect because they output Error: Could not find or load main class BirdDisplay.class'),(7,'Given the following class, which of the following is true? (Choose all that apply)','1: Public class Snake { <br/>\n 2:  <br/>\n 3:     public void shed(boolean time) { <br/>\n 4:  <br/>\n 5:         if(time){ <br/>\n 6:  <br/>\n 7:         }<br/>  \n 8:         System.out.println(result);  <br/>\n 9:  <br/>\n 10:    } <br/>\n 11: }<br/>','If String result = \"done\"; is inserted on line 2, the code will compile.','If String result = \"done\"; is inserted on line 4, the code will compile.','If String result = \"done\"; is inserted on line 6, the code will compile.','If String result = \"done\"; is inserted on line 9, the code will compile.','None of the above changes will make the code compile',NULL,NULL,NULL,'','','\0','\0','\0',NULL,NULL,NULL,'A, B. Adding the variable at line 2 makes result an instance variable.\nSince instance variables are in scope for the entire life of the object, option A is correct.\nOption B is correct because adding the variable at line 4 makes result a local variable with a scope of the whole method.\nAdding the variable at line 6 makes result a local variable with a scope of lines 6–7. Since it is out of scope on line 8, the println does not compile and option C is incorrect.\nAdding the variable at line 9 makes result a local variable with a scope of lines 9 and 10. Since line 8 is before the declaration, it does not compile and option D is incorrect.\nFinally, option E is incorrect because the code can be made to compile. '),(8,'Which of the following are true?',NULL,'an istance variable of type double defaults to null','an istance variable of type int defaults to null','an istance variable type String defaults to null','an istance variable of type double default to 0.0','an istance variable of type int defaults 0.0','an istance variable of type String default to 0.0','none of the above',NULL,'\0','\0','','\0','\0','\0','\0',NULL,' Option C is correct because all non-primitive values default to null Option D is correct because float and double primitives default to 0.0. Options B and E are incorrect because int primitives default to 0.'),(9,'Given the following classes, wich of the following snippets can be inserted in place of INSERT IMPORTS HERE and have the code compile? (Choose all apply)','package acquarium;\n	public class Water{\n	boolean salty = false;\n	}\n	package acquarium.jellies;\n	public class Water{\n	boolean salty = true;\n	}\n	package employee;\n	INSERT IMPORTS HERE\n	public class WaterFiller {\n	Water water;\n	}','import acqiarium.*;','import acquarium.Water;\n	 import acquarium.jellies.*;','import acquarium.*;\n	 import acquarium.jellies.Water;','import acquarium.*;\n	 import acquarium.jellies.*;','import acquarium.Water;\n	  import aquarium.jellies.Water;','Non of these imports can make the code compile.',NULL,NULL,'','','','\0','\0','\0',NULL,NULL,'A, B, C.\n	 Option A is correct because it imports all the classes in the aquarium package including aquarium.Water.\n      Options B and C are correct because they import Water by classname. Since importing by classname takes precedence over wildcards, these compile. \n      Option D is incorrect because Java doesn’t know which of the two wildcard Water classes to use. \n      Option E is incorrect because you cannot specify the same classname in two imports.'),(10,'What is the output of the following program?','1: public class WaterBottle { \n<br/>\n2: private String brand; \n<br/>\n3: private boolean empty; \n<br/>\n4: public static void main(String[]args){ \n<br/>\n5: WaterBottle wb = new WaterBottle(); \n<br/>\n6: System.out.print(\"Empty = \" + wb.empty); \n<br/>\n7: System.out.print(\", Brand = \" + wb.brand); \n<br/>\n8: } }','A. Line 6 generates a compiler error.','B. Line 7 generates a compiler error.','C. There is no output.','D. Empty = false, Brand = null','E. Empty = false, Brand =','F. Empty = null, Brand =null',NULL,NULL,'\0','\0','\0','','\0','\0',NULL,NULL,'D. Boolean fields initialize to false and references initialize to null, so empty is false and brand is null. Brand = null is output.'),(11,'Which of the following are true?','(Choose all that apply)','line 4 generates a compiler error','line 5 generates a compiler error','line 6 generates a compiler error','line 7 generates a compiler error','line 8 generates a compiler error','line 9 generates a compiler error','the code compiles as is',NULL,'\0','','\0','','','\0','\0',NULL,'B, D, E. Option A (line 4) compiles because short is an integral type. Option B (line 5) generates a compiler error because int is an integral type, but 5.6 is a floating-point type. Option C (line 6) compiles because it is assigned a String. Options D and E (lines 7 and 8) do not compile because short and int are primitives. Primitives do not allow methods to be called on them. Option F (line 9) compiles because length() is defined on String.'),(12,'Given the following classes, which of the following can independently replace INSERT IMPORTS HERE to make the code compile? (Choose the apply)','pachage acquarium, \n                       public class Tank, \n                       package aquarium.jellies;\n                       public class Jelly {}\n                       package visitor;\n                       INSERT IMPORTS HERE\n                       public class AquariumVisitor {\n                         public void admire (Jelly jelly) {}}','Import aquarium.*;','import aquarium.*Jelly;','import aquarium.jellies.Jelly;','import aquarium.jellies.*;','import aquarium.jellies.Jelly.*;','None of these can make the code compile.',NULL,NULL,'\0','\0','','','\0','\0',NULL,NULL,'Option C si correct because it imports Jelly by classname. Option D is correct because it imports all the classes in the jellies package, which includes Jelly. Option A is incorrect those in lower-level packages, Option B is incorrect because you cannot use wildcards anyplace other than the end of an import statment. Opion E is incorrect because you cannot import parts of a class with a regular import statement. Option F is incorrect because option C and D do make the code compile.'),(13,'Which of the following are valid java variable declarations?','(Choose the apply)','String txt ;','Integer $1 ;','Boolean _a ;','int Pub ;','Object b_ ;','char a3 ;','None of listed above are valid.',NULL,'','','','','','\0','\0',NULL,'There are only three rules to remember for legal identifiers:\n■ The name must begin with a letter or the symbol $ or _.\n■ Subsequent characters may also be numbers(beyond that letters, $ and _ character).\n■ You cannot use the same name as a Java reserved word.'),(14,'Which of the following are valid http verbs?','(Choose the apply)','GET','STOP','PICK','PUT','PATCH','DELETE','All of listed above are valid.','NNone of listed above are valid.','','\0','\0','','','','\0','\0','The primary or most-commonly-used HTTP verbs (or methods, as they are properly called) \n                       are POST, GET, PUT, PATCH, and DELETE. These correspond to create, read, update, and delete (or CRUD) operations, respectively. \n					   There are a number of other verbs, too, but are utilized less frequently.'),(15,'What does means sql?','(Choose the apply)','Start Query Language','Simple Query Loading','Structured Query Language','Simple Query Language','Sequel Query Language','All of listed above are valid.','None of listed above are valid.',NULL,'\0','\0','','\0','\0','\0','\0',NULL,'SQL stands for Structured Query Language. SQL is used to communicate with a database.'),(16,'In Javascript which of the following are valid variable declarations?','(Choose the apply)','var person = \"John Doe\", carName = \"Volvo\", price = 200;','var test2;','var Prefix = 10;','All of listed above are valid.','None of listed above are valid.',NULL,NULL,NULL,'','','','','\0',NULL,NULL,NULL,'The general rules for constructing names for variables, in javascript, (unique identifiers) are:\n    Names can contain letters, digits, underscores, and dollar signs.\n    Names must begin with a letter, with $ and _ .\n    Names are case sensitive (y and Y are different variables)\n    Reserved words (like JavaScript keywords) cannot be used as names.\n    You can declare many variables in one statement.'),(17,'What does means css?','(Choose the apply)','Custom Style Selector','Cross Style Structure','Change Sleep Style','Cascading Style Sheets','All of listed above are valid.','None of listed above are valid.',NULL,NULL,'\0','\0','\0','','\0','\0',NULL,NULL,'CSS stands for Cascading Style Sheets. CSS is a language that describes the style of an HTML document.\n                        CSS describes how HTML elements should be displayed.'),(18,'In Java, a class can extends another class?','(Choose only one)','yes','no',NULL,NULL,NULL,NULL,NULL,NULL,'','\0',NULL,NULL,NULL,NULL,NULL,NULL,'Yes, in Java, a class can extends an other class.'),(19,'In Java, an interface can extends another interface?','(Choose only one)','yes','no',NULL,NULL,NULL,NULL,NULL,NULL,'','\0',NULL,NULL,NULL,NULL,NULL,NULL,'Yes, in Java, an interface can extends an other interface.'),(20,'In Java, an abstract class can be instantiated?','(Choose only one)','yes','no',NULL,NULL,NULL,NULL,NULL,NULL,'\0','',NULL,NULL,NULL,NULL,NULL,NULL,'Yes, in Java, an abstract cannot be instantiated.'),(21,'Which of the following polymorphism concepts are rights?','(Choose the apply)','Polymorphism allows you to implement multiple methods within the same class that use the same name but a different set of input parameters.','Polymorphism does not allows you to implement multiple methods within the same class that use the same name and the same set of input parameters.','Within an inheritance hierarchy, a subclass can override a method of its superclass.','Within an inheritance hierarchy, a subclass cannot override a method of its superclass.',NULL,NULL,NULL,NULL,'','\0','','',NULL,NULL,NULL,NULL,'Polymorphism describes the concept that objects of different types can be accessed through the same interface.\nOverload allows you to implement multiple methods within the same class that use the same name but a different set of input parameters.\nOverride allows you to write a method in a class and write a method with the same signature in a child class.'),(22,'In a relational database a primary key....','(Choose the apply)','...must contain a unique value','...can contain duplicated values','..can contain null values','...uniquely identify a record',NULL,NULL,NULL,NULL,'','\0','\0','',NULL,NULL,NULL,NULL,'A primary key is a special relational database table column (or combination of columns) designated to uniquely identify all table records.\n						A primary key must contain a unique value for each row of data. It cannot contain null values.'),(23,'JDK stands for?',NULL,'Java Developer Kit','Java Development Kit ',NULL,NULL,NULL,NULL,NULL,NULL,'\0','',NULL,NULL,NULL,NULL,NULL,NULL,'JDK stands for Java Development Kit'),(24,'JRE stands for?',NULL,'Java Runtime Environment','Java Run Time Environment','Java Run Env',NULL,NULL,NULL,NULL,NULL,'','\0','\0',NULL,NULL,NULL,NULL,NULL,'JRE stands for Java Runtime Environment'),(25,'JVM stands for?',NULL,'Java Virtual Memory','Java Virtual Machine','Java Virtual Memory Machine',NULL,NULL,NULL,NULL,NULL,'\0','','\0',NULL,NULL,NULL,NULL,NULL,'JVM stands for Java Virtual Machine.'),(26,'What is the purpose of of the JAVA_HOME environment variable?',NULL,'It sets the virtual machine folder location.','It sets the system jre location.','It sets the private jre location.','It sets the jdk installation folder. ','None of the above.',NULL,NULL,NULL,'\0','\0','\0','','\0',NULL,NULL,NULL,'JAVA_HOME usually contains the jdk installation folder path.'),(27,'What is the purpose of of the JRE_HOME environment variable?',NULL,'JRE_HOME variable pointing to the bin subfolder of the java installation folder.','JRE_HOME variable poining to the java libraries.','JRE_HOME variable pointing to your jre installation folder.','All of the above.','Non of the above.',NULL,NULL,NULL,'\0','\0','','\0','\0',NULL,NULL,NULL,'JRE_HOME variable pointing to your JRE installation folder.'),(28,'Which of the following java print out \"Hello World\" to the console?\"','(Choose all that apply)','System.out.print(\"Hello World\");','System.out.print(\"Hello\" + \"World\");','System.out.println(\"Hello\" + \"World\");','System.out.print(\"Hello\"); System.out.println(\"World\");','System.out.println(\"Hello World\");','System.out.println(\"Hello\"); System.out.print(\"World\");','All of the above.',NULL,'','','','','','\0','\0',NULL,NULL),(29,'After installed jdk, usually CLASSPATH environment variable what should it contain?',NULL,'It should contain pointing to the \"lib\" subfolder.','It should contain pointing to the \"bin\" subfolder.','Non of the above.',NULL,NULL,NULL,NULL,NULL,'','\0','\0',NULL,NULL,NULL,NULL,NULL,NULL),(30,'What is the command I have to call if I want to compile a java class from command line?',NULL,'javax','java','javac','jws','Non of the above',NULL,NULL,NULL,'\0','\0','','\0','\0',NULL,NULL,NULL,NULL),(31,'What is the command I have to call if I want to run a class file from command line?',NULL,'java','javac','jre','jawas',NULL,NULL,NULL,NULL,'','\0','\0','\0',NULL,NULL,NULL,NULL,NULL),(32,'Which of the following are true?','(Choose all that apply)','An instance variable of type boolean defaults to false.','An instance variable of type boolean defaults to true.','An instance variable of type boolean defaults to null.','An instance variable of type int defaults to 0.','An instance variable of type int defaults to 0.0.','An instance variable of type int defaults to null.',NULL,NULL,'','\0','\0','','\0','\0',NULL,NULL,'A, D. Options A and D are correct because boolean primitives default to false and int primitives default to 0.'),(33,'Given the following class in the file /my/directory/named/A/Bird.java: INSERT CODE HERE public class Bird {}','Which of the following replaces INSERT CODE HERE if we compile from /my/directory?(Choose all that apply)','package my.directory.named.a;','package my.directory.named.A;','package named.a;','package named.A;','package a;','package A;','Does not compile.',NULL,'\0','\0','\0','','\0','\0','\0',NULL,'D. The package name represents any folders underneath the current path, which is named.A in this case. Option B is incorrect because package names are case sensitive, just like variable names and other identifiers.'),(34,'Which of the following lines of code compile?','(Choose all that apply)','int i1 = 1_234;','double d1 = 1_234_.0;','double d2 = 1_234._0;','double d3 = 1_234.0_;','double d4 = 1_234.0;','None of the above.',NULL,NULL,'','\0','\0','\0','','\0',NULL,NULL,'A, E. Underscores are allowed as long as they are directly between two other digits. This means options A and E are correct. Options B and C are incorrect because the underscore is adjacent to the decimal point. Option D is incorrect because the under- score is the last character.'),(35,'Given the following class, which of the following lines of code can replace INSERT CODE HERE to make the code compile? (Choose all that apply)','public class Price { public void admission() { INSERT CODE HERE System.out.println(amount); } }','int amount = 9L;','int amount = 0b101;','int amount = 0xE;','double amount = 0xE;','double amount = 1_2_.0_0;','int amount = 1_2_;','None of the above.',NULL,'\0','','','','\0','\0','\0',NULL,'B, C, D. 0b is the prefix for a binary value and is correct. 0x is the prefix for a hexa- decimal value. This value can be assigned to many primitive types, including int and double , making options C and D correct. Option A is incorrect because 9L is a long value. long amount = 9L would be allowed. Option E is incorrect because the under- score is immediately before the decimal. Option F is incorrect because the underscore is the very last character.'),(36,'Which of the following are true? (Choose all that apply)','public class Bunny { public static void main(String[] args) { Bunny bun = new Bunny(); } }','Bunny is a class.','bun is a class.','main is a class.','Bunny is a reference to an object.','bun is a reference to an object.','main is a reference to an object.','None of the above.',NULL,'','\0','\0','\0','','\0','\0',NULL,'A, E. Bunny is a class, which can be seen from the declaration: public class Bunny . bun is a reference to an object. main() is a method.'),(37,'Which represent the order in which the following statements can be assembled into a pro- gram that will compile successfully?','(Choose all that apply) A: class Rabbit {} B: import java.util.*; C: package animals;','A, B, C','B, C, A','C, B, A','B, A','C, A','A, C','A, B',NULL,'\0','\0','','','','\0','\0',NULL,'C, D, E. package and import are both optional. If both are present, the order must be package , then import , then class . Option A is incorrect because class is before package and import . Option B is incorrect because import is before package . Option F is incorrect because class is before package . Option G is incorrect because class is before import .'),(38,'Suppose we have a class named Rabbit. Which of the following statements are true? (Choose all that apply)','1: public class Rabbit { 2: public static void main(String[] args) { 3: Rabbit one = new Rabbit(); 4: Rabbit two = new Rabbit(); 5: Rabbit three = one; 6: one = null; 7: Rabbit four = one; 8: three = null; 9: two = null; 10: two = new Rabbit(); 11: System.gc(); 12: } }','The Rabbit object from line 3 is first eligible for garbage collection immediately following line 6.','The Rabbit object from line 3 is first eligible for garbage collection immediately following line 8.','The Rabbit object from line 3 is first eligible for garbage collection immediately following line 12.','The Rabbit object from line 4 is first eligible for garbage collection immediately following line 9.','The Rabbit object from line 4 is first eligible for garbage collection immediately following line 11.','The Rabbit object from line 4 is first eligible for garbage collection immediately following line 12.',NULL,NULL,'\0','','\0','','\0','\0',NULL,NULL,'B, D. The Rabbit object from line 3 has two references to it: one and three . The ref- erences are nulled out on lines 6 and 8, respectively. Option B is correct because this makes the object eligible for garbage collection after line 8. Line 7 sets the reference four to the now null one , which means it has no effect on garbage collection. The Rab- bit object from line 4 only has a single reference to it: two . Option D is correct because this single reference becomes null on line 9. The Rabbit object declared on line 10 becomes eligible for garbage collection at the end of the method on line 12. Calling System.gc() has no effect on eligibility for garbage collection.'),(39,'What is true about the following code? (Choose all that apply)','public class Bear { protected void finalize() { System.out.println(\"Roar!\"); }Review Questions public static void main(String[] args) { Bear bear = new Bear(); bear = null; System.gc(); } }','finalize() is guaranteed to be called.','finalize() might or might not be called','finalize() is guaranteed not to be called.','Garbage collection is guaranteed to run.','Garbage collection might or might not run.','Garbage collection is guaranteed not to run.','The code does not compile.',NULL,'\0','','\0','\0','','\0','\0',NULL,'B, E. Calling System.gc() suggests that Java might wish to run the garbage collector. Java is free to ignore the request, making option E correct. finalize() runs if an object attempts to be garbage collected, making option B correct.'),(40,'What does the following code output?','1: public class Salmon { 2: int count; 3: public void Salmon() { 4: count = 4; 5: } 6: public static void main(String[] args) { 7: Salmon s = new Salmon(); 8: System.out.println(s.count); 9: } }','0','4','Compilation fails on line 3.','Compilation fails on line 4.','Compilation fails on line 7.','Compilation fails on line 8.',NULL,NULL,'','\0','\0','\0','\0','\0',NULL,NULL,'A. While the code on line 3 does compile, it is not a constructor because it has a return type. It is a method that happens to have the same name as the class. When the code runs, the default constructor is called and count has the default value (0) for an int .'),(41,'Which of the following are true statements?','(Choose all that apply)','Java allows operator overloading.','Java code compiled on Windows can run on Linux.','Java has pointers to specific locations in memory.','Java is a procedural language.','Java is an object-oriented language.','Java is a functional programming language.',NULL,NULL,'\0','','\0','\0','','\0',NULL,NULL,'B, E. C++ has operator overloading and pointers. Java made a point of not having either. Java does have references to objects, but these are pointing to an object that can move around in memory. Option B is correct because Java is platform independent. Option E is correct because Java is object oriented. While it does support some parts of functional programming, these occur within a class.'),(42,'Which of the following are true?','(Choose all that apply)','javac compiles a .class file into a .java file.','javac compiles a .java file into a .bytecode file.','javac compiles a .java file into a .class file.','Java takes the name of the class as a parameter.','Java takes the name of the .bytecode file as a parameter.','Java takes the name of the .class file as a parameter.',NULL,NULL,'\0','\0','','','\0','\0',NULL,NULL,'C, D. Java puts source code in .java files and bytecode in .class files. It does not use a .bytecode file. When running a Java program, you pass just the name of the class without the .class extension.'),(43,'Which of the following are true?','(Choose all that apply) <br/> <ul><li>4: short numPets = 5;</li> <li>5: int numGrains = 5.6; </li><li>6: String name = \"Scruffy\";</li><li>7: numPets.length();</li><li>8: numGrains.length();</li><li>9: name.length();</li></ul>','Line 4 generates a compiler error.','Line 5 generates a compiler error.','Line 6 generates a compiler error.','Line 7 generates a compiler error.','Line 8 generates a compiler error.','Line 9 generates a compiler error.','The code compiles as is.',NULL,'\0','','\0','','','\0','\0',NULL,'B, D, E. Option A (line 4) compiles because short is an integral type. Option B (line 5) generates a compiler error because int is an integral type, but 5.6 is a floating-point type. Option C (line 6) compiles because it is assigned a String . Options D and E (lines 7 and 8) do not compile because short and int are primitives. Primitives do not allow methods to be called on them. Option F (line 9) compiles because length() is defined on String .');

--
-- Table structure for table `surveyquestions`
--



CREATE TABLE `surveyquestions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `survey_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_SurveyQuestion` (`survey_id`,`question_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `surveyquestions_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`),
  CONSTRAINT `surveyquestions_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ;
--INSERT INTO `surveyquestions` VALUES (1,1,10,2),(3,1,7,4),(4,1,12,5),(5,1,5,6),(6,1,9,7),(7,1,8,11),(8,1,4,10),(9,1,2,12),(10,3,13,1),(11,4,13,10),(12,3,14,2),(13,4,14,9),(14,3,15,3),(15,4,15,8),(16,3,16,4),(17,4,16,7),(18,3,17,5),(19,4,17,6),(20,3,18,6),(21,4,18,5),(22,3,19,7),(23,4,19,4),(24,3,20,8),(25,4,20,3),(26,3,21,9),(27,4,21,2),(28,3,22,10),(29,4,22,1),(30,5,23,1),(31,5,24,2),(32,5,25,3),(33,5,26,4),(34,5,27,5),(35,5,28,6),(36,5,29,7),(37,5,30,8),(38,5,31,9),(39,5,4,10),(40,1,32,13),(41,1,33,14),(42,1,34,15),(43,1,35,16),(44,1,36,17),(45,1,37,18),(46,1,38,19),(47,1,39,20),(48,1,40,21),(49,1,41,22),(50,1,42,23),(51,1,1,1),(52,1,43,3),(53,1,6,8),(54,1,3,9);

CREATE TABLE `surveyreplies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `survey_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `answers` varchar(5000) DEFAULT NULL,
  `pdffilename` varchar(100) DEFAULT NULL,
  `points` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `survey_id` (`survey_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `surveyreplies_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`),
  CONSTRAINT `surveyreplies_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `coursepage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) NOT NULL,
  `code` varchar(100) NOT NULL,
  `body_text` mediumtext NOT NULL,
  `file_name` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
);
INSERT INTO `coursepage` VALUES (1,'Candidatura generica','MIGEN01','Candidatura spontanea',NULL),(2,'Candidatura corso FullStackWeb+Java 01 Milano','MICEACFS01','Candidatura partecipazione a I Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Gen18-Mar18',NULL),(3,'Candidatura corso FullStackWeb+Java 02 Milano','MICEACFS02','Candidatura partecipazione a II Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Apr18-Giu18',NULL),(4,'Candidatura corso FullStackWeb+Java 03 Milano','MICEACFS03','Candidatura partecipazione a III Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Nov18-Gen19',NULL),(5,'Candidatura corso FullStackWeb+Java 04 Milano','MICEACFS04','Candidatura partecipazione a IV Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Mar19-Mag19',NULL),(6,'Candidatura corso FullStackWeb+Java 05 Milano','MICEACFS05','Corso FullStack Java 05 - Milano',NULL);

CREATE TABLE `candidate_states` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `status_code` int(11) NOT NULL,
  `status_label` varchar(300) DEFAULT NULL,
  `status_description` varchar(1000) DEFAULT NULL,
  `status_color` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `candidate_states_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);
INSERT INTO `candidate_states` VALUES (1,4,1,'DA VALUTARE','entry appena effettuata. Stato: DA VALUTARE - DEFAULT','#f60000'),(2,4,2,'ha rinunciato','Ha rinunciato di sua scelta al corso','#f98742'),(3,4,3,'inadeguato standing/comportamentale','Scartato per inadeguatezza in termini di standing o criticità comportamentali','#f9c842'),(4,4,4,'inadeguato background','Scartato per inadeguatezza del suo backround','#f9ec14'),(5,4,5,'per corso formatemp','inadeguato backround/standing/altre criticità ma potrebbe rientrare in caso di formatemp','#0e81ec'),(6,4,6,'background solo parzialmente adeguato, NON LAUREATO/NON LAUREANDO','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. NON LAUREATO/NON LAUREANDO','#2585de'),(7,4,7,'background solo parzialmente adeguato, LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','background parzialmente adeguato, tenere in considerazione nella fase finale della selezione. LAUREATO/LAUREANDO in materie informatiche, matematiche o affini','#25ded3'),(8,4,8,'OK. Background di prima scelta. NON LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#7af914'),(9,4,9,'OK. Background di prima scelta. LAUREATO/LAUREANDO. Buona motivazione e backgound','OK già da subito.','#63b81e');


CREATE TABLE `interviews` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_text` varchar(255) DEFAULT NULL,
  `ansa` varchar(255) DEFAULT NULL,
  `ansb` varchar(255) DEFAULT NULL,
  `ansc` varchar(255) DEFAULT NULL,
  `ansd` varchar(255) DEFAULT NULL,
  `anse` varchar(255) DEFAULT NULL,
  `ansf` varchar(255) DEFAULT NULL,
  `ansg` varchar(255) DEFAULT NULL,
  `ansh` varchar(255) DEFAULT NULL,
  `ansi` varchar(255) DEFAULT NULL,
  `ansj` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


--OPTIONALLY FOR NOW --PT.2 - START

CREATE TABLE `candidates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `domicile_city` varchar(100) DEFAULT NULL,
  `study_qualification` varchar(300) DEFAULT NULL,
  `graduate` tinyint(1) DEFAULT NULL,
  `high_graduate` tinyint(1) DEFAULT NULL,
  `still_high_study` tinyint(1) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `cv_external_path` varchar(1000) DEFAULT NULL,
  `course_code` varchar(100) NOT NULL,
  `candidacy_date_time` datetime NOT NULL,
  `label` varchar(200) DEFAULT NULL,
  `candidate_states_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `course_code` (`course_code`),
  KEY `candidate_states_id` (`candidate_states_id`),
  CONSTRAINT `candidates_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `candidates_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `coursepage` (`code`),
  CONSTRAINT `candidates_ibfk_3` FOREIGN KEY (`candidate_states_id`) REFERENCES `candidate_states` (`id`)
) ;
--INSERT INTO `candidates` VALUES (1,1,'Milano','Laurea Magistrale in Sticazzologia',1,0,0,'3896317801','1.pdf','MICEACFS04','2019-05-23 07:36:08',NULL,1);

CREATE TABLE `course_resume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `code` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`),
  UNIQUE KEY `code` (`code`),
  CONSTRAINT `course_resume_ibfk_1` FOREIGN KEY (`code`) REFERENCES `coursepage` (`code`)
) ;


CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `domicile_city` varchar(100) DEFAULT NULL,
  `domicile_street_name` varchar(100) DEFAULT NULL,
  `domicile_house_number` varchar(100) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `cv_external_path` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `itconsultants` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `domicile_city` varchar(100) DEFAULT NULL,
  `domicile_street_name` varchar(100) DEFAULT NULL,
  `domicile_house_number` varchar(100) DEFAULT NULL,
  `study_qualification` varchar(300) DEFAULT NULL,
  `graduate` tinyint(1) DEFAULT NULL,
  `high_graduate` tinyint(1) DEFAULT NULL,
  `still_high_study` tinyint(1) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `cv_external_path` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `itconsultants_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
); 

CREATE TABLE `surveyinterviews` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `survey_id` bigint(20) NOT NULL,
  `interview_id` bigint(20) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_SurveyInterview` (`survey_id`,`interview_id`),
  KEY `interview_id` (`interview_id`),
  CONSTRAINT `surveyinterviews_ibfk_1` FOREIGN KEY (`survey_id`) REFERENCES `surveys` (`id`),
  CONSTRAINT `surveyinterviews_ibfk_2` FOREIGN KEY (`interview_id`) REFERENCES `interviews` (`id`)
);


CREATE TABLE `usersurveytoken` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `surveyid` bigint(20) NOT NULL,
  `generatedtoken` varchar(50) DEFAULT NULL,
  `expirationdate` datetime DEFAULT NULL,
  `expired` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueToken` (`generatedtoken`),
  KEY `userid` (`userid`),
  KEY `surveyid` (`surveyid`),
  CONSTRAINT `usersurveytoken_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `usersurveytoken_ibfk_2` FOREIGN KEY (`surveyid`) REFERENCES `surveys` (`id`)
);

--OPTIONALLY FOR NOW --PT.2 - END
