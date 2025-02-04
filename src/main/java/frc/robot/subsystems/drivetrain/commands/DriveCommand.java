package frc.robot.subsystems.drivetrain.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain.DriveSubsystem;

public class DriveCommand extends Command {
    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier xSpeed;
    private final DoubleSupplier zRotation;

    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier xSpeed, DoubleSupplier zRotation) {
        this.driveSubsystem = subsystem;
        this.xSpeed = xSpeed;
        this.zRotation = zRotation;
        addRequirements(this.driveSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        driveSubsystem.driveArcade(this.xSpeed.getAsDouble(), this.zRotation.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {

    }
}
