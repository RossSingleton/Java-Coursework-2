import org.junit.*;

public class Assessment2UnitTests {
    /*
     * Tests for Q1.
     */
     
    // Test Animal constructor and accessors.
    // marks=1.75
    @Test ( timeout=4000 )
    public void q1testA() {
        Animal a = new Animal( "Tiger", 5 );
        Assert.assertEquals( "Tiger", a.getName() );
        Assert.assertEquals( 5, a.getTotalAnimals() );
        Assert.assertEquals( 5, a.getAvailableAnimals() );
    }
    
    // Test Animal constructor input validation.
    // marks=0.25
    @Test ( timeout=4000, expected=IllegalArgumentException.class )
    public void q1testB() {
        Animal a = new Animal( "Tiger", 0 );
    }
    
    // Test Animal loan to and return from other collections.
    // marks=2.0 
    @Test ( timeout=4000 ) 
    public void q1testC() {
        Animal a = new Animal( "Tiger", 3 );
        a.loanAnimal();
        a.loanAnimal();
        Assert.assertEquals( 1, a.getAvailableAnimals() );
        a.loanAnimal();
        Assert.assertEquals( 0, a.getAvailableAnimals() );
        a.returnAnimal();
        Assert.assertEquals( 1, a.getAvailableAnimals() );
    }
    
    // Test Animal returns from other collections validation.
    // marks=0.25
    @Test ( timeout=4000, expected=IllegalStateException.class )
    public void q1testD() {
        Animal a = new Animal( "Tiger", 1 );
        a.loanAnimal();
        Assert.assertEquals( 0, a.getAvailableAnimals() );
        a.loanAnimal();
    }
    
    // Test Animal returns from other collections validation.
    // marks=0.25
    @Test ( timeout=4000, expected=IllegalStateException.class )
    public void q1testE() {
        Animal a = new Animal( "Tiger", 3 );
        a.returnAnimal();
    }
    
    // Test Animal information hiding (good programming practice!).
    // marks=0.5
    @Test ( timeout=4000 )
    public void q1testF() {
        Animal a = new Animal( "Tiger", 20 );
        if( TestTools.countNonPrivateFields( Animal.class ) > 0 )
            Assert.fail( "Animal's fields should be hidden." );
    }
    
    /*
     * Tests for Q2.
     */
     
    // Test basic usage of an infinite-capacity Zoo.
    // marks=0.6
    @Test ( timeout=4000 )
    public void q2testA() {
        Zoo z = new Zoo();

        Animal a = new Animal( "Tiger", 20 );
        z.addAnimal( a );
    }
    
    // Test basic usage of a limited-capacity Zoo.
    // marks=0.6
    @Test ( timeout=4000 )
    public void q2testB() {
        Zoo z = new Zoo(10);

        Animal a = new Animal( "Tiger", 4 );
        z.addAnimal( a );
    }
    
    // Test input validation on a limited-capacity Zoo.
    // marks=0.20
    @Test ( timeout=4000, expected=IllegalArgumentException.class )
    public void q2testC() {
        Zoo z = new Zoo(0);
    }
    
    // Test Zoo capacity validation (pt1)
    // marks=0.20
    @Test ( timeout=4000, expected=IllegalStateException.class )
    public void q2testD1() {
        Zoo z = new Zoo(4);
        z.addAnimal( new Animal("Lion", 1) );
        z.addAnimal( new Animal("Monkey", 1) );
        z.addAnimal( new Animal("Bactrian Camel", 1) );
        z.addAnimal( new Animal("Eastern Diamondback Rattlesnake", 1) );
        z.addAnimal( new Animal("Slender Loris", 1) );
    }
    
    // Test Zoo capacity validation (pt2)
    // marks=0.20
    @Test ( timeout=4000, expected=IllegalStateException.class )
    public void q2testD2() {
        Zoo z = new Zoo(4);
        z.addAnimal( new Animal("Lion", 2) );
        z.addAnimal( new Animal("Monkey", 1) );
        z.addAnimal( new Animal("Bactrian Camel", 2) );
    }
    
    // Test getting Animals from Zoo
    // marks=1.0
    @Test ( timeout=4000 )
    public void q2testE() {
        Zoo z = new Zoo(10);
        Animal a1 = new Animal("Lion", 3);
        Animal a2 = new Animal("Monkey", 3);
        Animal a3 = new Animal("Bactrian Camel", 4);
        z.addAnimal( a1 );
        z.addAnimal( a2 );
        z.addAnimal( a3 );
        Assert.assertSame( a2, z.getAnimalWithName("Monkey") );
        Assert.assertSame( a2, z.getAnimalWithName("moNKeY") );
        Assert.assertSame( a3, z.getAnimalWithName("Bactrian cAMeL") );
        Assert.assertNull( z.getAnimalWithName("Western Bearded Dragon") );
    }
    
    // Test checking if animal exists
    // marks=0.5
    @Test ( timeout=4000 )
    public void q2testF() {
        Zoo z = new Zoo(10);
        Animal a1 = new Animal("Lion", 3);
        Animal a2 = new Animal("Monkey", 3);
        Animal a3 = new Animal("Bactrian Camel", 4);
        z.addAnimal( a1 );
        z.addAnimal( a2 );
        z.addAnimal( a3 );
        Assert.assertEquals( true, z.hasAnimalWithName("Monkey") );
        Assert.assertEquals( true, z.hasAnimalWithName("moNKeY") );
        Assert.assertEquals( true, z.hasAnimalWithName("Bactrian cAMeL") );
        Assert.assertEquals( false, z.hasAnimalWithName("Western Bearded Dragon") );
        Assert.assertEquals( false, z.hasAnimalWithName("Monkeys") );
        Assert.assertEquals( false, z.hasAnimalWithName("Camel") );
    }
    
    // Test counting number of available animals
    // marks=1.5
    @Test ( timeout=4000 )
    public void q2testG() {
        Zoo z = new Zoo();
        Assert.assertEquals( 0, z.numberAvailableAnimals() );

        Animal a1 = new Animal("Lion", 3);
        Animal a2 = new Animal("Monkey", 3);
        Animal a3 = new Animal("Bactrian Camel", 4);
        z.addAnimal( a1 );
        z.addAnimal( a2 );
        z.addAnimal( a3 );
        Assert.assertEquals( 10, z.numberAvailableAnimals() );

        a1.loanAnimal();
        a1.loanAnimal();
        a1.loanAnimal();
        Assert.assertEquals( 7, z.numberAvailableAnimals() );

        a1.returnAnimal();
        Assert.assertEquals( 8, z.numberAvailableAnimals() );

        a2.loanAnimal();
        a3.loanAnimal();
        a3.loanAnimal();
        Assert.assertEquals( 5, z.numberAvailableAnimals() );
    }
    
    // Test Animal information hiding (good programming practice!).
    // marks=0.2
    @Test ( timeout=4000 )
    public void q2testH() {
        Zoo z = new Zoo( 20 );
        if( TestTools.countNonPrivateFields( Zoo.class ) > 0 )
            Assert.fail( "Zoo's fields should be hidden." );
    }
    
}