(import '[vtk
  vtkConeSource vtkPolyDataMapper vtkActor
  vtkRenderer vtkRenderWindow vtkRenderWindowInteractor
  vtkNativeLibrary])

(vtkNativeLibrary/LoadAllNativeLibraries)

(let [cone (vtkConeSource.)
      mapper (vtkPolyDataMapper.)
      actor (vtkActor.)
      renderer (vtkRenderer.)
      window (vtkRenderWindow.)
      interactor (vtkRenderWindowInteractor.)]

  (.SetResolution cone 8)

  (.SetInputConnection mapper (.GetOutputPort cone))

  (.SetMapper actor mapper)

  (.AddActor renderer actor)
  (.SetBackground renderer 0.2 0.3 0.4)

  (.AddRenderer window renderer)
  (.SetSize window 640 480)

  (.SetRenderWindow interactor window)

  (.Render window)
  (.Start interactor))
