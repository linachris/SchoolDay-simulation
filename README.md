>### **Εντολή μεταγλώττισης**: <code> make </code> 
(αρχείο Makefile)

Ή <code> javac Main.java People_package/\*.java Ids_package/\*.java Areas_package/*.java </code>

>#### *Ενδεικτική εκτέλεση: java Main 3 5 10 12 8*

<code> java Main < Classroom capacity > < Junior Student's exhaustion > < Senior Student's exhaustion > < Teacher's exhaustion > < School Hours >
</code>
- **Σημείωση**:
    1. Για την συγκεκριμένη main, επειδή έχουν χρησιμοποιηθεί οι πίνακες από το Ids_package/ids.java για την δημιουργία των μαθητών και των καθηγητών(2 μαθητές & 1 καθηγητής ανά αίθουσα), το 1ο όρισμα πρέπει να είναι == 3.

    2. Σύμφωνα με το ids.java, σε κάθε όροφο στις αίθουσες 1-3 υπάρχουν Junior Students, 
    ενώ στις 4-6 Senior Students. 

    3. Έχει χρησιμοποιηθεί η κλάση ArrayList της Java, με interface List.

>### **Αρχεία :**
Οργάνωση κώδικα στα packages:
- **People_package:**
    - *Members:* Person.java, Teacher.java, Student.java, Senior.java, Junior.java --> Η υλοποίηση της έννοιας άνθρωπος(Person: (Student(Junior, Senior), Teacher)).
- **Areas_package:** 
    - *Members:* Area.java, School.java, Yard.java, Stairs.java, Floor.java, Corridor.java, Classroom.java --> Η υλοποίηση των λειτουργιών του σχολείου(κάθε χώρου Area) που περιγράφονται στην εκφώνηση.
- **Ids_package:**
    - *Members:* ids.java --> Τα array με στοιχεία μαθητών/καθηγητών για την δοκιμαστική main.
- ./Main.java
- ./Makefile -> Για την μεταγλώττιση και τη σύνδεση όλων των αρχείων.

Σημείωση: Για να χρησιμοποιηθούν τα μέλη ενός πακέτου(τα protected δεδομένα και οι public μέθοδοι) σε άλλα πακέτα, προστίθεται η δήλωση **import Name_package.*** σε αυτά. 

>### **Βασικότερες έννοιες άσκησης :**
>Στην άσκηση αυτή, υλοποιείται μια προσομοίωση της πρωινής άφιξης μαθητών σε ένα σχολικό κτήριο και εισόδου τους στις αίθουσες.

- Το σχολικό κτήριο(School) αποτελείται από 1 αυλή(Yard), 1 κλιμακοστάσιο(Stairs), 3 ορόφους(Floor), 
καθένας από τους οποίους έχει έναν διάδρομο(Corridor) και 6 τάξεις(Classroom). 

- Κάθε μαθητής(Student) αναπαρίσταται από το όνομα του, τον όροφο και την τάξη στην οποία ανήκει, 
καθώς και μια ένδειξη για το αν βρίσκεται στην τάξη ή όχι.

- Κάθε καθηγητής(Teacher) αναπαρίσταται από το όνομα του, τον όροφο και την τάξη στην οποία ανήκει,
κάθως και μια ένδειξη για το αν βρίσκεται στην τάξη ή όχι.

Η διαδρομή που ακολουθεί ο μαθητής είναι η εξής: `School-->Yard-->Stairs-->Floor-->Corridor-->Classroom`

Η διαδρομή που ακολουθεί ο καθηγητής είναι η εξής: `School-->Floor-->Classroom`

>### Ζητούμενες λειτουργίες
|           |    Enter   |    Exit    |    Place    |    Operate    |  Print   |  Empty  | teacher(s)_out |
|:---------:|:----------:|:----------:|:-----------:|:-------------:|:--------:|:-------:|:--------------:|
| School    |      x     |            |      x      |      x        |    x     |    x    |                |
| Yard      |      x     |     x      |             |               |          |         |                |
| Stairs    |      x     |     x      |             |               |          |         |                |
| Floor     |      x     |     x      |      x      |      x        |    x     |         |       x        |
| Corridor  |      x     |     x      |             |               |          |         |                |
| Classroom |      x     |     x      |      x      |      x        |    x     |         |       x        |

|           |    Print    |   Attend   |    Teach    |
|:---------:|:-----------:|:----------:|:-----------:|
| Student   |      x      |     x      |             |
| Teacher   |      x      |            |      x      | 


> ### **Αναπαραστάσεις Αφηρημένων Εννοιών :**

> Παρατηρώντας από τους παραπάνω πίνακες πως κάποιες οντότητες του κόσμου του σχολείου έχουν κοινά χαρακτηριστικά, για να υλοποιηθούν οι λειτουργίες τους αυτές, υλοποιούνται κάποιες αφηρημένες έννοιες, που αναπαρίστανται από τις κλάσεις: __Area__, __Person__.

- Η κλάση ***Area*** αποτελεί abstract υπερκλάση(δεν μπορούν να οριστούν αντικείμενα αυτής), εφόσον περιέχει τις abstract μεθόδους: *enter* & *exit*. Την κληρονομούν οι υποκλάσεις **Yard**, **Stairs**, **Corridor**(is-a), με κοινά χαρακτηριστικά τις παραπάνω λειτουργίες, τις οποίες και επαναορίζουν.

    - Πιο συγκεκριμένα, η κλάση Area, έχει σαν protected μέλος μία *αναφορά* σε *ArrayList* (που κάθε φορά θα κρατάει ένα μόνο μαθητή για κάθε χώρο που κληρονομεί την κλάση Area - {εκτός από την Classroom, που θα κρατάει πλήθος μαθητών}). Σαν protected, έχει οριστεί ώστε όταν βρισκόμαστε στην εμβέλεια της κάθε υποκλάσης της Area, να έχουμε προσβάση στο arraylist αυτό, για την προσθήκη(μέσω της enter), και την αφαίρεση(μέσω της exit) του μαθητή σε κάθε χώρο.

- Η κλάση ***Person*** αποτελεί abstract υπερκλάση(δεν μπορούν να οριστούν αντικείμενα αυτής), την οποία κληρονόμουν οι υποκλάσεις **Student**, **Teacher** (is-a), εφόσον είναι *εξειδικεύσεις ανθρώπων* με κοινά χαρακτηριστικά/λειτουργίες, με μόνες διάφορες τους βαθμούς κούρασης, και τις λειτουργίες attend, teach, print(abstract method που επαναορίζεται).
    
    - Πιο συγκεκριμένα, η κλάση Person έχει σαν protected μέλη τα στοιχεία ενός ανθρώπου του σχολείου *(όνομα, αριθμός ορόφου/αίθουσας, ένδειξη για το αν βρίσκεται στην τάξη που ανήκει, μετρητής κούρασης)*, και σαν public μεθόδους τους αντίστοιχους accessors των παραπάνω στοιχείων. Σαν protected, έχουν οριστεί ώστε όταν βρισκόμαστε στην εμβέλεια της κάθε υποκλάσης της Person, και αντίστοιχα της Student, να έχουμε άμεση προσβάση στα στοιχεία αυτά.
    
- Την κλάση ***Student*** με την σειρά τους κληρονόμουν οι υποκλάσεις **Senior**, **Junior** (is-a), εφόσον είναι *εξειδικεύσεις μαθητών*, με μόνη διαφορά τον βαθμό κούρασης τους.

>### __Αναπαραστάσεις Χώρων :__

- Οι υποκλάσεις ***Yard***, ***Stairs***, ***Corridor*** της *Area* (is-a), επαναορίζουν τις abstract methods: *enter & exit*.

- Η κλάση ***Floor***, είναι μια συνθέτη κλάση (has-a), καθώς έχει σαν private μέλη-δεδομένα, τον αριθμό του[1,3], μία *αναφορά* σε κλάση *Corridor*, και έναν *πίνακα αναφορών* σε *Classroom*, ώστε να έχει πρόσβαση και στους επιμέρους αυτούς χώρους, από την στιγμή που πρέπει να τους διαχειριστεί μέσω των λειτουργιών (*enter & exit & place & teachers_out & operate & print*). Παρότι έχει κάποιες κοινές λειτουργίες με της υπόλοιπες υποκλάσεις της abstract κλάσης Area, δεν έχει σαν μέλος, αναφορά σε ArrayList, καθώς δεν κρατάει μαθητές(απλά τους προωθεί στους επόμενους χώρους).

- Η κλάση ***School*** είναι μια συνθέτη κλάση (has-a), καθώς έχει σαν private μέλη-δεδομένα, μία *αναφορά* σε *Yard*, μία *αναφορά* σε *Stairs*, και ένα *πίνακα αναφορών* σε *Floor*, ώστε να έχει πρόσβαση και στους επιμέρους αυτούς χώρους, από την στιγμή που πρέπει να τους διαχειριστεί μέσω των λειτουργιών (*enter & place & empty & operate & print*).

- Η υποκλάση ***Classroom*** της *Area* (is-a) επαναορίζει τις abstract methods: *enter & exit & place & teacher_out & operate & print*. Είναι ο μόνος χώρος τύπου Area που κρατάει έναν καθηγητή, και σε ένα ArrayList πλήθος μαθητών, και χαρακτηρίζεται από μία χωρητικότητα και έναν αριθμό αίθουσας[1,6].

>### __Λειτουργίες Χώρων :__

#### *Σύμφωνα με την εκφώνηση υλοποιούνται οι παρακάτω λειτουργίες :*
1. Σε κάθε **enter** εκτυπώνεται το μήνυμα "``` < Student > enters < χώρος >! ```".
2. Σε κάθε **exit** εκτυπώνεται το μήνυμα "``` < Student > exits < χώρος >! ```".
3. Σε κάθε **print** Student/Teacher εκτυπώνεται το όνομα τους και ο βαθμός κούρασης.

4. **Yard, Stairs, Corridor :** ***enter / exit :***
    - Εισάγει (enter) και αφαιρεί (exit) έναν μαθητή κάθε φορά στο/από το arraylist που αναπαριστά τον εκάστοτε χώρο.
5. **School, Floor, Classroom :** ***enter / place / operate / print :***      
    
    - ***School*** : Η **enter** καλεί τις αντίστοιχες enter/exit των Yard, Stairs και την enter του Floor για έναν μαθητή. Η **place** τοποθετεί τον καθηγητή στο σχολείο. Η **operate** λειτουργεί τους ορόφους του σχολείου κάποιες ώρες(δίνεται σαν παράμετρος από τον χρήστη). Η **print** εκτυπώνει τους ορόφους του σχολείου.  Η **empty** βγάζει όλους τους μαθητές από τους ορόφους, το κλιμακοστάσιο, και την αυλή ακολουθιακά, και στην συνέχεια τους καθηγητές. 
    
    - ***Floor*** : Η **enter** καλεί τις αντίστοιχες enter/exit της Corridor και την enter της Classroom. Η **place** τοποθετεί τον καθηγητή στον όροφο της αίθουσας που ανήκει. Η **operate** λειτουργεί τις αίθουσες του κάποιες ώρες(δίνεται σαν παράμετρος από τον χρήστη). Η **print** εκτυπώνει τις αίθουσες του ορόφου. Η **exit** βγάζει έναν μαθητή από την αίθουσα και τον βάζει στον διάδρομο. Η **teachers_out** βγάζει όλους τους καθηγητές του σχολείου από τις αίθουσες τους.

    - ***Classroom*** : Η **enter** εισάγει τον μαθητή στο ArrayList της αίθουσας που ανήκει. Η **place** τοποθετεί τον καθηγητή στην αίθουσα που ανήκει. Στην **operate** οι μαθητές παρακολουθούν μάθημα(***attend***) που οι καθηγητές διδάσκουν(***teach***) για κάποιες ώρες(δίνεται σαν παράμετρος από τον χρήστη). Η **print** εκτυπώνει τον καθηγητή και τους μαθητές της αίθουσας. Η **exit** βγάζει έναν μαθητή από την αίθουσα. Η **teacher_out** βγάζει έναν καθηγητή του σχολείου από την αίθουσα.

>### **Δημιουργία :**
Ο χρήστης μέσω της main αναλαμβάνει την δημιουργία μαθητών(Student) {Junior & Senior}, καθηγητών(Teacher), και του σχολείου(School).
Ένας μαθητής/καθηγητής δημιουργείται αρχικοποιώντας τα στοιχεία του με στοιχεία από τον πίνακα studentInfo/teacherInfo (από το Ids_package/ids.java), εκτυπώνοντας *"A new Student/Teacher has been created..."*.

***Ένα σχολείο δημιουργείται:*** 
- Mε τον **constructor** της κλάσης ***School***, να καλεί τον **constructor**
    - της ***Yard***, των ***Stairs***, δημιουργώντας έτσι την *αυλή και το κλιμακοστάσιο*, 
    - και των ***Floor*** δημιουργώντας έτσι *3 ορόφους*. 

    - Τα 3 floors αντίστοιχα, καλούν τους **constructors** των ***Corridor***, ***Classroom***, 
δημιουργώντας έτσι *1 διάδρομο και 6 τάξεις για κάθε όροφο* αντίστοιχα.

Με την σειρά αυτή εκτυπώνονται και τα μηνύματα *" A new <Χώρος> has been created!"*.

>### **Δοκιμαστική main**
Κάθε Classroom έχει capacity = 3 {2 μαθητές και 1 καθηγητής} δηλαδή οι μαθητές συνολικά είναι 36, και οι καθηγητές 18.
Οι μαθητές/καθηγητές που εισάγονται μέσω των enter/place στο σχολείο, βρίσκονται στον πίνακα studentInfo/teacherInfo του Ids_package/ids.java, 
και έχουν τα κατάλληλα δεδομένα ώστε να πληρούνται οι παραπάνω αριθμοί μαθητών και καθηγητών που απαιτούνται. 
Οι constructors των Students, Teachers, έχουν σαν ορίσματα τα δεδομένα του παραπάνω πίνακα, και κρατάνε τους μαθητές και καθηγητές στους πίνακες students, teachers αντίστοιχα. 

Για να εξασφαλιστεί η τυχαιότητα της εισαγωγής σύμφωνα με την εκφώνηση, οι παραπάνω πίνακες ανακατεύονται μέσω μιας βοηθητικής συνάρτησης ***shuffle***(overloading), και καλούνται οι enter/place με ορίσματα μαθητές και καθηγητές από τους πίνακες αυτούς.

###
    1. Δημιουργείται ένα σχολικό κτήριο.
    2. Δημιουργούνται οι μαθητές και οι καθηγητές του.
    3. Μπαίνουν μαθητές και τοποθετούνται καθηγητές στο σχολικό κτήριο με τυχαία σειρά.
    4. Το σχολικό κτήριο λειτουργεί για N ώρες.
    5. Εκτυπώνεται το σχολικό κτήριο.
    6. Πραγματοποιείται εκκένωση κτηρίου.