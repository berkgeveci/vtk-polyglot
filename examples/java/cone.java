import vtk.vtkConeSource;
import vtk.vtkPolyDataMapper;
import vtk.vtkActor;
import vtk.vtkRenderer;
import vtk.vtkRenderWindow;
import vtk.vtkRenderWindowInteractor;
import vtk.vtkNativeLibrary;

public class cone {
    static {
        vtkNativeLibrary.LoadAllNativeLibraries();
    }

    public static void main(String[] args) {
        vtkConeSource cone = new vtkConeSource();
        cone.SetResolution(8);

        vtkPolyDataMapper mapper = new vtkPolyDataMapper();
        mapper.SetInputConnection(cone.GetOutputPort());

        vtkActor actor = new vtkActor();
        actor.SetMapper(mapper);

        vtkRenderer renderer = new vtkRenderer();
        renderer.AddActor(actor);
        renderer.SetBackground(0.2, 0.3, 0.4);

        vtkRenderWindow window = new vtkRenderWindow();
        window.AddRenderer(renderer);
        window.SetSize(640, 480);

        vtkRenderWindowInteractor interactor = new vtkRenderWindowInteractor();
        interactor.SetRenderWindow(window);

        window.Render();
        interactor.Start();
    }
}
