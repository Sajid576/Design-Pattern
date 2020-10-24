/**
 * Adaptee: the interface/class that is going to be added with my existing system.
 * Target Interface: My existing interface that clients can interact with.
 */

// This is the Target Interface : This is what the client
// expects to work with. It is the adapters job to make new
// classes compatible with this one.
interface EnemyAttacker {
    public void fireWeapon();
    public void driveForward();
    public void assignDriver(String driverName);
}
// EnemyTank implements EnemyAttacker perfectly
// Our job is to make classes with different methods
// from EnemyAttacker to work with the EnemyAttacker interface
class EnemyTank implements EnemyAttacker{
	public void fireWeapon() {
		System.out.println("Enemy tank firing weapon ");	
	}
	public void driveForward() {
		System.out.println("Enemy Tank moving forward");	
	}
	public void assignDriver(String driverName) {
		System.out.println(driverName + " is driving the tank");	
	}
}

// This is the Adaptee. The Adapter sends method calls
// to objects that use the EnemyAttacker interface
// to the right methods defined in EnemyRobot
class EnemyRobot{
	public void smashWithHands() {
		System.out.println("Enemy Robot Causes Damage With Its Hands");	
	}
	public void walkForward() {
		System.out.println("Enemy Robot Walks Forward ");	
	}
	public void reactToHuman(String driverName) {
		System.out.println("Enemy Robot Tramps on " + driverName);	
	}
}
// The Adapter must provide an alternative action for 
// the the methods that need to be used because
// EnemyAttacker was implemented.

// This adapter does this by containing an object
// of the same type as the Adaptee (EnemyRobot)
// All calls to EnemyAttacker methods are sent
// instead to methods used by EnemyRobot

class EnemyRobotAdapter implements EnemyAttacker{
    /**
     * 1) The adapter class contains a  object/interface of that adaptee class.
     * In this example we are using adaptee object.
     * 2) The adapter class implements the target interface
     */
	EnemyRobot theRobot;
	public EnemyRobotAdapter(EnemyRobot newRobot){
		theRobot = newRobot;
	}
	public void fireWeapon() {	
		theRobot.smashWithHands();
	}
	public void driveForward() {	
		theRobot.walkForward();
	}
	public void assignDriver(String driverName) {	
		theRobot.reactToHuman(driverName);
	}
}
public class example_1{
	
	public static void main(String[] args){
		
		EnemyTank rx7Tank = new EnemyTank();
		
		EnemyRobot fredTheRobot = new EnemyRobot();
		
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);
		
		System.out.println("The Robot");
		
		fredTheRobot.reactToHuman("Paul");
		fredTheRobot.walkForward();
		fredTheRobot.smashWithHands();
		System.out.println();
		
		System.out.println("The Enemy Tank");
		
		rx7Tank.assignDriver("Frank");
		rx7Tank.driveForward();
		rx7Tank.fireWeapon();
		System.out.println();
		
		System.out.println("The Robot with Adapter");
		
		robotAdapter.assignDriver("Mark");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();

	}
	
}