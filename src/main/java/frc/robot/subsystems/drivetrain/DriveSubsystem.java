package frc.robot.subsystems.drivetrain;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

public class DriveSubsystem extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(DriveConstants.leftLeaderMotor, MotorType.kBrushless);
    private final SparkMax leftFollower = new SparkMax(DriveConstants.leftFollowerMotor, MotorType.kBrushless);
    private final SparkMax rightLeader = new SparkMax(DriveConstants.rightLeaderMotor, MotorType.kBrushless);
    private final SparkMax rightFollower = new SparkMax(DriveConstants.rightFollowerMotor, MotorType.kBrushless);
    private final DifferentialDrive drive = new DifferentialDrive(leftLeader, rightLeader);

    private static final class SpeedPID {
        public static final double p = 1.0;
        public static final double i = 0.0;
        public static final double d = 0.0;
    }

    private final RelativeEncoder encoder = leftLeader.getEncoder();
    private final ProfiledPIDController speedPidController = new ProfiledPIDController(
            SpeedPID.p,
            SpeedPID.i,
            SpeedPID.d,
            null);

    public DriveSubsystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.follow(leftLeader);
        leftFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        config.follow(rightLeader);
        rightFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void driveArcade(double xSpeed, double zRotation) {
        drive.arcadeDrive(speedPidController.calculate(encoder.getVelocity(), xSpeed), zRotation);
    }
}
