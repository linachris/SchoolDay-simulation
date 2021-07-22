JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java\
	Areas_package/*.java\
	People_package/*.java\
	Ids_package/*.java\

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) Areas_package/*.class
	$(RM) People_package/*.class
	$(RM) Ids_package/*.class
	$(RM) Main.class

run:
	java Main 3 5 10 12 7