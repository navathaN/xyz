import org.robokind.api.animation.Animation;
import org.robokind.api.animation.messaging.RemoteAnimationPlayerClient;
//import org.robokind.api.animation.player.AnimationJob;
import org.robokind.api.common.position.NormalizedDouble;
import org.robokind.api.motion.Joint;
import org.robokind.api.motion.messaging.RemoteRobot;
import org.robokind.api.speech.messaging.RemoteSpeechServiceClient;
import org.robokind.client.basic.*;
import static org.robokind.api.motion.Robot.*;
import static org.robokind.client.basic.RobotJoints.*;

/**
 * A simple class to make the robot smile
 * @author Lianne Meah <lianne.meah@gmail.com?>
 */

public class ZenoSmile {
    private static RobotPositionMap myGoalPositions;
        
    /*
     * default contructor
     */
    public ZenoSmile() {
        
    }
    
    public void smile(RemoteRobot myRobot) {
        String measure;
        double measureDouble = 0.5;
        JointId eyelids = new JointId(myRobot.getRobotId(), new Joint.Id(EYELIDS)); 
        JointId eyes_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(EYES_PITCH)); 
        JointId left_eye_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_EYE_YAW)); 
        JointId right_eye_yaw = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_EYE_YAW));
        JointId left_smile = new JointId(myRobot.getRobotId(), new Joint.Id(LEFT_SMILE));
        JointId right_smile = new JointId(myRobot.getRobotId(), new Joint.Id(RIGHT_SMILE));
        JointId neck_pitch = new JointId(myRobot.getRobotId(), new Joint.Id(NECK_PITCH));
        this.myGoalPositions = new RobotPositionHashMap();
        
        myGoalPositions.put(left_smile, new NormalizedDouble(0.9));
        myGoalPositions.put(right_smile, new NormalizedDouble(0.9));
        // look up, Zeno!
        myGoalPositions.put(neck_pitch, new NormalizedDouble(0.7));
        //myGoalPositions.put(eyelids, new NormalizedDouble(0.9));
        myRobot.move(myGoalPositions, 1000);    
    }
    
    public void testJoint(String joint) {
        
    }
    
}
