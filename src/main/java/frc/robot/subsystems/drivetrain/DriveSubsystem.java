package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

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

    public DriveSubsystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.follow(leftLeader);
        leftFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        config.follow(rightLeader);
        rightFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void driveArcade(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }

    // public SparkMax getLeftLeader() {
    // return leftLeader;
    // }

    // public SparkMax getLeftFollower() {
    // return leftFollower;
    // }

    // public SparkMax getRightLeader() {
    // return rightLeader;
    // }

    // public SparkMax getRightFollower() {
    // return rightFollower;
    // }
}
