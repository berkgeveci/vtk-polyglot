import vtk.vtkNativeLibrary
import vtk.vtkConeSource
import vtk.vtkPolyDataMapper
import vtk.vtkActor
import vtk.vtkRenderer
import vtk.vtkRenderWindow
import vtk.vtkRenderWindowInteractor

vtkNativeLibrary.LoadAllNativeLibraries()

def cone = new vtkConeSource()
cone.SetResolution(8)

def mapper = new vtkPolyDataMapper()
mapper.SetInputConnection(cone.GetOutputPort())

def actor = new vtkActor()
actor.SetMapper(mapper)

def renderer = new vtkRenderer()
renderer.AddActor(actor)
renderer.SetBackground(0.2, 0.3, 0.4)

def window = new vtkRenderWindow()
window.AddRenderer(renderer)
window.SetSize(640, 480)

def interactor = new vtkRenderWindowInteractor()
interactor.SetRenderWindow(window)

window.Render()
interactor.Start()
